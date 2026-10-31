
public class FastExponentiation {

    public static long power(long x, int n) {
        if (n == 0) {
            return 1;
        }

        long half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return x * half * half;
    }

    public static void main(String[] args) {
        long x = 2;
        int n = 10;

        long result = power(x, n);

        System.out.println(x + "^" + n + " = " + result);
    }
}
