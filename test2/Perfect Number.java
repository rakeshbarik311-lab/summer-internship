import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, sum = 0;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                sum = sum + i;
            }
        }

        if(sum == num)
            System.out.println("Perfect Number");
        else
            System.out.println("Not a Perfect Number");
    }
}