package brestprog.factorization;

public class SimplePrime {
    public static void main(String[] args) {
        System.out.print(isPrime(101));
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
