import java.util.Scanner;

public class probF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        sc.close();

        int sum = 0;
        for (int i = 0; i < 3; ++i)
            sum += s.charAt(i) - '0';

        int ans = sum % 10 + ((sum + sum / 10) % 10) * 10 + (sum + (sum + sum / 10) / 10) * 100;
        System.out.println(ans);
    }
}
