import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class probH {

    static Map<Integer, Integer> branch = new HashMap<>();
    static Map<Integer, Integer> size = new HashMap<>();
    static int n, m;

    static int findBranch(int u) {
        int b = branch.getOrDefault(u, -1);
        if (b == -1) {
            branch.put(u, u);
            return u;
        } else if (b == u) {
            return u;
        } else {
            int B = findBranch(b);
            branch.put(u, B);
            return B;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; ++i) {
            branch.put(i, i); // set root
            size.put(i, 1);
        }

        for (int i = 0; i < m; ++i) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            int rootA = findBranch(a);
            int rootB = findBranch(b);

            if (rootA != rootB) {
                branch.put(rootB, rootA); // merge

                int lenBranchA = size.getOrDefault(rootA, 1);
                int lenBranchB = size.getOrDefault(rootB, 1);

                size.put(rootA, lenBranchA + lenBranchB);
            }
        }

        int amountOfRooms = 1;
        for (int k : size.keySet()) {
            int lenBranchK = size.get(k);
            if (lenBranchK > amountOfRooms)
                amountOfRooms = lenBranchK;
        }

        System.out.println(amountOfRooms);
        sc.close();
    }
}
