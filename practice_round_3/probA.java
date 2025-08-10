import java.util.Scanner;

public class probA {
    static int p3(int a, int b, int c) {
        if (a == b && b == c)
            return 1;
        if (a != b && b != c && a != c)
            return 6;
        return 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int k, s;
        k = sc.nextInt();
        s = sc.nextInt();

        //
        int M_x = (s / 3) < k ? (s / 3) : k;
        long ans = 0;
        for (int x = 0; x <= M_x; ++x) {
            int m_y = (s - x) >> 1;
            int M_y = m_y < k ? m_y : k;
            for (int y = x; y <= M_y; ++y) {
                int z = s - x - y;
                if (z <= k)
                    ans += p3(x, y, z);
                // System.out.printf("%d %d %d - %d\n", x, y, z, ans);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
