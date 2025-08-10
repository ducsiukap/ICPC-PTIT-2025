import java.util.ArrayList;
import java.util.Scanner;

public class probH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int t[] = new int[n + 1];
        int edge[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i)
            t[i] = 0;

        int total = 0;
        for (int i = 0; i < m; ++i) {
            int t1, t2, w;
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            w = sc.nextInt();

            t[t1] += w;
            t[t2] += w;
            total += w;

            edge[t1][t2] = w;
            edge[t2][t1] = w;
        }

        int yi = total / n;
        int xi = t[1];
        for (int i = 2; i <= n; ++i)
            xi = xi < t[i] ? xi : t[i];

        int zi = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <= n; ++j) {
                if (edge[i][j] != 0) {
                    int Zi = t[i] + t[j] - edge[i][j];
                    zi = zi < Zi ? zi : Zi;
                }
            }
        }
        zi >>= 1;
        xi = xi < zi ? xi : zi;
        int maximum = xi < yi ? xi : yi;

        int ans = total - maximum * n;
        System.out.println(ans);
        sc.close();
    }
}


// 46/48 test