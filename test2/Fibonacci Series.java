import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, a = 0, b = 1, c;

        System.out.print("Enter number of terms: ");
        n = sc.nextInt();

        System.out.print(a + " " + b + " ");

        for(int i = 3; i <= n; i++) {
            c = a + b;
            System.out.print(c + " ");

            a = b;
            b = c;
        }
    }
}