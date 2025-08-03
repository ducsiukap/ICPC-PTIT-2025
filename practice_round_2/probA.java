import java.util.Scanner;

public class probA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxEdge = -1, totalSum = 0;
        for (int i = 0; i < n; ++i) {
            int edge = sc.nextInt();
            maxEdge = (edge > maxEdge ? edge : maxEdge);
            totalSum += edge;
        }

        maxEdge <<= 1;
        System.out.println((totalSum > maxEdge ? "Yes" : "No"));
        sc.close();
    }

}
