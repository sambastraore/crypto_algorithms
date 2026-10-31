
public class JacobiSymbol {

    public static int jacobi(long n, long m) {
        if (m <= 0 || m % 2 == 0) {
            throw new IllegalArgumentException(
                "m doit etre positif et impair"
            );
        }

        n = Math.floorMod(n, m);
        int t = 1;

        while (n != 0) {
            int k = 0;

            while (n % 2 == 0) {
                k++;
                n /= 2;
            }

            if (k % 2 == 1 && (m % 8 == 3 || m % 8 == 5)) {
                t = -t;
            }

            if (n % 4 == 3 && m % 4 == 3) {
                t = -t;
            }

            long temp = n;
            n = m % temp;
            m = temp;
        }

        return (m == 1) ? t : 0;
    }

    public static void main(String[] args) {
        System.out.println("J(5, 11) = " + jacobi(5, 11));
        System.out.println("J(2, 15) = " + jacobi(2, 15));
        System.out.println("J(3, 7)  = " + jacobi(3, 7));
        System.out.println("J(6, 9)  = " + jacobi(6, 9));
    }
}
