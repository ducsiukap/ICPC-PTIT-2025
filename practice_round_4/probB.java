import java.util.Arrays;
import java.util.Scanner;

public class probB {
    static int binarySearch(int[] arr, int n, int target) {
        int i, j;
        i = 0;
        j = n - 1;

        if (arr[i] >= target)
            return arr[0] - target;
        if (arr[j] <= target)
            return target - arr[j];

        int smaller, bigger;
        smaller = arr[i];
        bigger = arr[j];

        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] == target)
                return 0;
            if (arr[mid] > target) {
                bigger = arr[mid];
                j = mid - 1;
            } else {
                smaller = arr[mid];
                i = mid + 1;
            }
        }

        return Math.min(target - smaller, bigger - target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] a, b;
        a = new int[n];
        b = new int[m];

        for (int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; ++i)
            b[i] = sc.nextInt();

        sc.close();

        Arrays.sort(a);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; ++i) {
            int best = binarySearch(a, n, b[i]);

            ans = Math.min(ans, best);
            if (ans == 0)
                break;
        }

        System.out.println(ans);
    }

}

// 1 2 4 6 8 9 10
// 5 i = 0, j = 6 -> mid = 3 = 6 > 5 => bigger = 6 => j = 2
// 5 i = 0, j = 2 =>mid = 1 => 2 < 5 => smaller = 2 => i = 2
// 5 i = j = 2 -> mid = 2 => 4 < 5 => smaller = 4
// return min(target - smaller, bigger - target)