import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, count = 0;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        for(int i = 1; i <= num; i++) {
            if(num % i == 0)
                count++;
        }

        if(count == 2)
            System.out.println("Prime Number");
        else
            System.out.println("Not a Prime Number");
    }
}