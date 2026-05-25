import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, temp, rem, sum = 0;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        temp = num;

        while(num > 0) {
            rem = num % 10;

            int fact = 1;

            for(int i = 1; i <= rem; i++) {
                fact = fact * i;
            }

            sum = sum + fact;
            num = num / 10;
        }

        if(sum == temp)
            System.out.println("Strong Number");
        else
            System.out.println("Not a Strong Number");
    }
}