import java.util.Scanner;

public class probJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            int m, n;
            m = sc.nextInt();
            n = sc.nextInt();
            short[][] area = new short[m + 1][n + 1];
            for (int i = 1; i <= m; ++i)
                for (int j = 1; j <= n; ++j)
                    area[i][j] = sc.nextShort();

            int totalArea = 0;
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (area[i][j] == 0)
                        continue;
                    totalArea += 4 * area[i][j] + 2;
                    int leftArea = area[i][j] < area[i][j - 1] ? area[i][j] : area[i][j - 1];
                    int aboveArea = area[i][j] < area[i - 1][j] ? area[i][j] : area[i - 1][j];
                    totalArea -= 2 * (leftArea + aboveArea);
                }
            }
            // System.out.print("Area: ");
            System.out.println(totalArea);
        }
        sc.close();
    }
}
