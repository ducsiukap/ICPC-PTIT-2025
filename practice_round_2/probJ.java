import java.util.Scanner;

public class probJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();

        long target = (a * a) << 1;
        a = (long) Math.sqrt(target);
        if (a * a == target)
            --a;

        a = a > 10000 ? 10000 : a;

        boolean isOk = false;
        for (long b = 1; b <= a; ++b) {
            long squareC = target - b * b;

            long c = (long) Math.sqrt(squareC);
            if (c * c == squareC && b != c && c <= 10000) {
                // System.out.println(">>> " + b + " " + c);
                isOk = true;
                break;
            }
        }

        System.out.println(isOk ? "YES" : "NO");

        sc.close();
    }
}
