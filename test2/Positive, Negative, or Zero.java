import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("Enter a number: ");
        num = sc.nextInt();

        if(num > 0)
            System.out.println("Positive Number");
        else if(num < 0)
            System.out.println("Negative Number");
        else
            System.out.println("Zero");
    }
}
