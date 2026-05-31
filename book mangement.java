import java.sql.*;
import java.util.Scanner;

public class BookManagementSystem {

    static final String URL = "jdbc:mysql://localhost:3306/library_db";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== BOOK MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Book");
                System.out.println("2. View Book");
                System.out.println("3. Update Book Price");
                System.out.println("4. Delete Book");
                System.out.println("5. Display All Books");
                System.out.println("6. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Publisher: ");
                        String publisher = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        String insert =
                                "INSERT INTO books VALUES(?,?,?,?,?,?)";

                        PreparedStatement ps1 =
                                con.prepareStatement(insert);

                        ps1.setInt(1, id);
                        ps1.setString(2, title);
                        ps1.setString(3, author);
                        ps1.setString(4, publisher);
                        ps1.setDouble(5, price);
                        ps1.setInt(6, qty);

                        ps1.executeUpdate();
                        System.out.println("Book Added Successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();

                        String select =
                                "SELECT * FROM books WHERE book_id=?";

                        PreparedStatement ps2 =
                                con.prepareStatement(select);

                        ps2.setInt(1, bookId);

                        ResultSet rs = ps2.executeQuery();

                        if (rs.next()) {
                            System.out.println("Book ID: " + rs.getInt("book_id"));
                            System.out.println("Title: " + rs.getString("title"));
                            System.out.println("Author: " + rs.getString("author"));
                            System.out.println("Publisher: " + rs.getString("publisher"));
                            System.out.println("Price: " + rs.getDouble("price"));
                            System.out.println("Quantity: " + rs.getInt("quantity"));
                        } else {
                            System.out.println("Book Not Found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Price: ");
                        double newPrice = sc.nextDouble();

                        String update =
                                "UPDATE books SET price=? WHERE book_id=?";

                        PreparedStatement ps3 =
                                con.prepareStatement(update);

                        ps3.setDouble(1, newPrice);
                        ps3.setInt(2, updateId);

                        int row = ps3.executeUpdate();

                        if (row > 0)
                            System.out.println("Price Updated Successfully!");
                        else
                            System.out.println("Book Not Found!");
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        int deleteId = sc.nextInt();

                        String delete =
                                "DELETE FROM books WHERE book_id=?";

                        PreparedStatement ps4 =
                                con.prepareStatement(delete);

                        ps4.setInt(1, deleteId);

                        int result = ps4.executeUpdate();

                        if (result > 0)
                            System.out.println("Book Deleted Successfully!");
                        else
                            System.out.println("Book Not Found!");
                        break;

                    case 5:
                        Statement st = con.createStatement();

                        ResultSet allBooks =
                                st.executeQuery("SELECT * FROM books");

                        System.out.println("\n--- Book Records ---");

                        while (allBooks.next()) {
                            System.out.println(
                                    allBooks.getInt("book_id") + " | " +
                                    allBooks.getString("title") + " | " +
                                    allBooks.getString("author") + " | " +
                                    allBooks.getString("publisher") + " | " +
                                    allBooks.getDouble("price") + " | " +
                                    allBooks.getInt("quantity"));
                        }
                        break;

                    case 6:
                        con.close();
                        System.out.println("Program Closed.");
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