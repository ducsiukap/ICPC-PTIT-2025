import java.util.Scanner;

public class probI {
    private static long Cnk(int n, int k) {
        long comb = 1;
        if (k > n - k)
            k = n - k;

        // n!/(k! * (n - k)*!)
        // c93 = 9!/(3!*6!) = (9 * 8 * 7)/(1 * 2 * 3)

        for (int i = 0; i < k; ++i) {
            comb = comb * (n - i) / (i + 1);
        }
        return comb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        long k;

        // System.out.println(
        // "babbbbbaaaaabbbaabbabbbbbbaaabaababbaaababbaaabaaaab" ==
        // "babbbbbaaaaabbbaabbabbbbbbaaabaababbaaababbaaabaaaab");

        a = sc.nextInt();
        b = sc.nextInt();
        k = sc.nextLong();

        while (a > 0 && b > 0) {

            long comb = Cnk(a + b - 1, b);
            // System.out.print(a + " " + b + " " + comb + " " + k + '-');

            if (k > comb) {
                System.out.print('b');
                --b;
                k -= comb;
            } else {
                System.out.print('a');
                --a;
            }
        }

        while (a > 0) {
            System.out.print('a');
            --a;
        }

        while (b > 0) {
            System.out.print('b');
            --b;
        }
        System.out.println();
        sc.close();
    }

}

/*
 * 000 11
 * 01 -> 2
 * 001 ->
 * 26 26
 * 25 26
 * c(51, 25) => 51!/25!*26!
 * 
 * c(9, 3) => 9!/3!*6!
 * 
 * 
 * 00101
 * 00110
 * 
 * 01001
 * 01010
 * 01100
 * 
 * 
 * 
 * 000 111
 * 000111
 * 
 * 001011
 * 001101
 * 001110
 * 
 * 010011
 * 010101
 * 010110
 * 011001
 * 011010
 * 011100
 */