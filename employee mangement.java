import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== Employee Management System =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employee");
                System.out.println("3. Update Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insert =
                            "INSERT INTO employee VALUES(?,?,?,?)";

                        PreparedStatement ps1 =
                            con.prepareStatement(insert);

                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setString(3, dept);
                        ps1.setDouble(4, salary);

                        ps1.executeUpdate();
                        System.out.println("Employee Added Successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Employee ID: ");
                        int empId = sc.nextInt();

                        String select =
                            "SELECT * FROM employee WHERE emp_id=?";

                        PreparedStatement ps2 =
                            con.prepareStatement(select);

                        ps2.setInt(1, empId);

                        ResultSet rs = ps2.executeQuery();

                        if (rs.next()) {
                            System.out.println("ID: " +
                                    rs.getInt("emp_id"));
                            System.out.println("Name: " +
                                    rs.getString("emp_name"));
                            System.out.println("Department: " +
                                    rs.getString("department"));
                            System.out.println("Salary: " +
                                    rs.getDouble("salary"));
                        } else {
                            System.out.println("Employee Not Found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String update =
                            "UPDATE employee SET salary=? WHERE emp_id=?";

                        PreparedStatement ps3 =
                            con.prepareStatement(update);

                        ps3.setDouble(1, newSalary);
                        ps3.setInt(2, updateId);

                        int rows = ps3.executeUpdate();

                        if (rows > 0)
                            System.out.println("Salary Updated!");
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        int deleteId = sc.nextInt();

                        String delete =
                            "DELETE FROM employee WHERE emp_id=?";

                        PreparedStatement ps4 =
                            con.prepareStatement(delete);

                        ps4.setInt(1, deleteId);

                        int d = ps4.executeUpdate();

                        if (d > 0)
                            System.out.println("Employee Deleted!");
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 5:
                        Statement st = con.createStatement();

                        ResultSet rsAll =
                            st.executeQuery("SELECT * FROM employee");

                        System.out.println("\nEmployee Records");

                        while (rsAll.next()) {
                            System.out.println(
                                rsAll.getInt("emp_id") + " | " +
                                rsAll.getString("emp_name") + " | " +
                                rsAll.getString("department") + " | " +
                                rsAll.getDouble("salary"));
                        }
                        break;

                    case 6:
                        con.close();
                        System.out.println("Program Ended");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
