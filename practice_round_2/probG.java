import java.util.Scanner;

public class probG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // ++n;
        long[] L = new long[n + 1];
        L[0] = 2L;
        L[1] = 1L;

        for (int i = 2; i <= n; ++i) {
            L[i] = L[i - 1] + L[i - 2];
            System.out.println(i + " - " + L[i]);
        }
        System.out.println(L[n]);
        sc.close();
    }
}
