import java.util.Scanner;

public class DuckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, rem;
        boolean isDuck = false;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        while(num > 0) {
            rem = num % 10;

            if(rem == 0) {
                isDuck = true;
                break;
            }

            num = num / 10;
        }

        if(isDuck)
            System.out.println("Duck Number");
        else
            System.out.println("Not a Duck Number");
    }
}