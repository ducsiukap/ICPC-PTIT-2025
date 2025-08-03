// import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;
// import java.util.Scanner;
// import java.util.TreeSet;

// public class probE {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int T = sc.nextInt();
//         for (int test = 0; test < T; ++test) {
//             int n, k;
//             n = sc.nextInt();
//             k = sc.nextInt();

//             Map<Integer, Integer> count = new HashMap<>();

//             for (int i = 0; i < n; ++i) {
//                 int x = sc.nextInt();
//                 count.put(x, count.getOrDefault(x, 0) + 1);
//             }

//             Set<Integer> key = new TreeSet<>(count.keySet());
//             for (int i : key)
//                 System.out.print(i + " ");
//         }
//         sc.close();
//     }
// }
