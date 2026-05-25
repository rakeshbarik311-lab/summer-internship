import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, temp, rem, sum = 0;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        temp = num;

        while(num > 0) {
            rem = num % 10;
            sum = sum + (rem * rem * rem);
            num = num / 10;
        }

        if(temp == sum)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }
}