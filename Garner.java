
public class Garner {

    // inverse modulaire de a modulo m
    public static long modInverse(long a, long m) {
        long m0 = m;
        long x0 = 0;
        long x1 = 1;

        while (a > 1) {
            long q = a / m;

            long temp = m;
            m = a % m;
            a = temp;

            temp = x0;
            x0 = x1 - q * x0;
            x1 = temp;
        }

        return (x1 % m0 + m0) % m0;
    }

    public static long garner(long[] a, long[] n) {
        int r = a.length;

        if (r != n.length || r == 0) {
            throw new IllegalArgumentException(
                "Les tableaux doivent avoir la même taille non nulle."
            );
        }

        long[] mu = new long[r];
        long[] c = new long[r];

        mu[0] = 1;

        for (int i = 1; i < r; i++) {
            mu[i] = mu[i - 1] * n[i - 1];
            c[i] = modInverse(mu[i] % n[i], n[i]);
        }

        long N = mu[r - 1] * n[r - 1];

        // Construction progressive de la solution
        long result = a[0];

        for (int i = 1; i < r; i++) {
            long u = (((a[i] - result) % n[i] + n[i]) * c[i]) % n[i];

            result = result + u * mu[i];
            result = result % N;
        }

        return (result % N + N) % N;
    }

    public static void main(String[] args) {
        long[] a = {2, 3, 2};
        long[] n = {3, 5, 7};

        long x = garner(a, n);

        System.out.println("Solution : x = " + x);

        for (int i = 0; i < a.length; i++) {
            System.out.println(
                x + " mod " + n[i] + " = " + (x % n[i])
            );
        }
    }
}
