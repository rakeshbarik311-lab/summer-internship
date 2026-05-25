import java.util.Scanner;

public class Prime1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter N: ");
        n = sc.nextInt();

        for(int i = 2; i <= n; i++) {
            int count = 0;

            for(int j = 1; j <= i; j++) {
                if(i % j == 0)
                    count++;
            }

            if(count == 2)
                System.out.println(i);
        }
    }
}