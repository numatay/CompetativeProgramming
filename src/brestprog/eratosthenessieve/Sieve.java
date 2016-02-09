package brestprog.eratosthenessieve;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABiryulin on 2/7/2016.
 */
public class Sieve {
    public static void main(String[] args) {
        final int SIZE = 10000;
        boolean[] sieve = new boolean[SIZE+1];

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= SIZE; i++) {
            if (!sieve[i]) {
                primes.add(i);

                for (int j = i * i; j <= SIZE; j += i) {
                    sieve[j] = true;
                }
            }
        }

        System.out.println(primes);
    }
}
