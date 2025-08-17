import java.util.Scanner;

public class probI {
    static int sumDigits(Long n) {
        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int T = 0; T < t; ++T) {
            Long n = sc.nextLong();
            long N = n;
            int s = sc.nextInt();

            int total = sumDigits(n);
            long pow = 10;
            while (total > s) {
                long last = n % pow;

                n = n - last + pow;

                total = sumDigits(n);
                // System.out.printf("n: %d | last: %d | pow: %d | total: %d\n", n, last, pow, total);
                pow *= 10;
            }

            System.out.println(n - N);
        }

        sc.close();
    }
}

// 1992 - 19
// 1 992 - 18
// 19 92 - 9
