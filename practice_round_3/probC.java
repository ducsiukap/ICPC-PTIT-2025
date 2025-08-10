import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class probC {
    static Set<String> tree = new TreeSet<>();
    static boolean stop = false;
    static String result;

    static void Try(int[] a, int i, int n, boolean[] mark, String s, int nth) {
        if (stop)
            return;
        if (i == n) {
            String res = "";
            for (int j = 0; j < n; ++j)
                res += s.charAt(a[j]);
            tree.add(res);
            if (tree.size() == nth) {
                stop = true;
                result = res;
            }
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (mark[j])
                continue;
            mark[j] = true;
            a[i] = j;
            Try(a, i + 1, n, mark, s, nth);
            mark[j] = false;
        }
    }

    static void calcPermutation(String s, int nth) {
        int n = s.length();
        Map<Character, Integer> charMap = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            int freq = charMap.getOrDefault(s.charAt(i), 0);
            charMap.put(s.charAt(i), freq + 1);
        }

        s = "";
        for (char character : charMap.keySet()) {
            int freq = charMap.get(character);
            while (freq > 0) {
                s += character;
                --freq;
            }
        }

        if (nth == 1) {
            result = s;
            return;
        }

        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; ++i)
            mark[i] = false;

        int a[] = new int[n];
        Try(a, 0, n, mark, s, nth);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int nth = sc.nextInt();
        calcPermutation(s, nth);
        System.out.println(result);
        sc.close();
    }
}