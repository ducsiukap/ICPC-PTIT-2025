import java.util.Scanner;

public class probB {
    public static void main(String[] args) {
        // 1 2 3 4 5
        // 5 3 1 2 4
        // 1 -> 2 1 -> 3 1 2 -> 4 2 1 3 -> 5 3 1 2 4
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];

        for (int t = 0; t < n; ++t) {
            a[t] = sc.nextInt();
        }

        boolean flip = false;
        for (int t = n - 1, i = 0, j = n - 1; t >= 0; --t) {
            if (flip) {
                b[j] = a[t];
                --j;
            } else {
                b[i] = a[t];
                ++i;
            }
            flip = !flip;
        }

        for (int t = 0; t < n; ++t)
            System.out.print(b[t] + " ");
        System.out.println();
        sc.close();
    }
}
