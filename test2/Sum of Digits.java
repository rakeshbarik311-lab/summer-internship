import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, sum = 0, rem;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        while(num > 0) {
            rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }

        System.out.println("Sum of digits = " + sum);
    }
}