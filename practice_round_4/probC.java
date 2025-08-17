import java.util.Scanner;

public class probC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] mark = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            String s = sc.next();
            for (int j = 0; j < n; ++j)
                mark[i][j] = (s.charAt(j) == '#');
        }
        sc.close();

        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j)
        // System.out.print(mark[i][j] + " ");
        // System.out.println();
        // }

        int[][][] count = new int[n][n][4]; // row, col, \,/
        if (!mark[0][0]) {
            count[0][0][0] = 1;
            count[0][0][1] = 1;
            count[0][0][2] = 1;
        }

        for (int i = 1; i < n; ++i) {
            int f;
            f = mark[0][i] ? 0 : 1;
            count[0][i][0] = count[0][i - 1][0] + f;
            count[0][i][1] = f;
            count[0][i][2] = f;

            f = mark[i][0] ? 0 : 1;
            count[i][0][1] = count[i - 1][0][1] + f;
            count[i][0][0] = f;
            count[i][0][2] = f;
        }

        for (int i = 1; i < n; ++i)
            for (int j = 1; j < n; ++j) {
                int f = mark[i][j] ? 0 : 1;
                count[i][j][0] = count[i][j - 1][0] + f;
                count[i][j][1] = count[i - 1][j][1] + f;
                count[i][j][2] = count[i - 1][j - 1][2] + f;
            }

        int k = n - 1;
        if (!mark[0][k])
            count[0][k][3] = 1;
        for (int i = 1; i < n; ++i) {
            int f = mark[0][k - i] ? 0 : 1;
            count[0][k - i][3] = f;

            f = mark[i][k] ? 0 : 1;
            count[i][k][3] = f;
        }

        for (int i = 1; i < n; ++i)
            for (int j = k - 1; j >= 0; --j) {
                int f = mark[i][j] ? 0 : 1;
                count[i][j][3] = count[i - 1][j + 1][3] + f;
            }

        boolean isOk = false;
        for (int j = 0; j < n; ++j) {
            isOk = count[5][j][1] <= 2;
            if (isOk)
                break;
        }
        for (int i = 6; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                isOk = (count[i][j][1] - count[i - 6][j][1]) <= 2;
                if (isOk)
                    break;
            }
        }

        if (!isOk) {
            for (int j = 0; j < n; ++j) {
                isOk = count[j][5][0] <= 2;
                if (isOk)
                    break;
            }
            for (int i = 6; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    isOk = (count[j][i][0] - count[j][i - 6][0]) <= 2;
                    if (isOk)
                        break;
                }
            }
        }

        if (!isOk) {
            for (int i = 5; i < n; ++i) {
                for (int j = 0; j < n - 5; ++j)
                    isOk = count[i][5 + j][2] <= 2;
            }
            for (int i = 6; i < n; ++i) {
                for (int j = 0; j < n - 6; ++j) {
                    isOk = (count[i][6 + j][2] - count[i - 6][j][2]) <= 2;
                    if (isOk)
                        break;
                }
            }
        }

        if (!isOk) {
            for (int j = 5; j < n; ++j)
                isOk = count[5][j - 5][3] <= 2;

            for (int i = 6; i < n; ++i)
                for (int j = 6; j < n; ++j) {
                    isOk = (count[i][j - 6][3] - count[i - 6][j][3]) <= 2;
                    if (isOk)
                        break;
                }
        }

        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j)
        // System.out.print(count[i][j][0] + " ");
        // System.out.println();
        // }
        // System.out.println();

        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j)
        // System.out.print(count[i][j][1] + " ");
        // System.out.println();
        // }
        // System.out.println();

        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j)
        // System.out.print(count[i][j][2] + " ");
        // System.out.println();
        // }
        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j)
        // System.out.print(count[i][j][3] + " ");
        // System.out.println();
        // }
        System.out.println(isOk ? "Yes" : "No");
    }
}

/*
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1
 */