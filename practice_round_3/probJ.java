import java.util.Arrays;
import java.util.Scanner;

public class probJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, c;
        n = sc.nextInt();
        c = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
        Arrays.sort(a);

        int ans = 0;
        for (int i = 0, j = n - 1; i <= j;) {
            ++ans;

            if (a[i] + a[j] <= c) {
                ++i;
                --j;
            } else {
                --j;
            }

        }

        System.out.println(ans);

        sc.close();
    }
}
