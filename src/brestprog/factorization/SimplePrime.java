package brestprog.factorization;

import java.util.*;

public class SimplePrime {
    public static void main(String[] args) {
        //System.out.print(isPrime(101));
        System.out.println(factorize1(128));
        System.out.println(factorize2(123123123));
        System.out.println(find_dividers1(123123123));
        System.out.println(find_dividers2(123123123));
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> factorize1(int x) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(x); i++) {
            while (x % i == 0) {
                factors.add(i);
                x /= i;
            }
        }

        if (x != 1) {
            factors.add(x);
        }
        return factors;
    }

    public static Map<Integer, Integer> factorize2(int x) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int i = 2; i <= Math.sqrt(x); i++) {
            while (x % i == 0) {
                if (factors.containsKey(i)) {
                    factors.put(i, factors.get(i) + 1);
                } else {
                    factors.put(i, 1);
                }
                x /= i;
            }
        }

        if (x != 1) {
            factors.put(x, 1);
        }
        return factors;
    }

    public static List<Integer> find_dividers1(int x) {
        List<Integer> dividers = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                dividers.add(i);

                if (i * i != x) {
                    dividers.add(x / i);
                }
            }
        }
        Collections.sort(dividers);
        return dividers;
    }

    public static List<Integer> find_dividers2(int x) {
        List<Integer> dividers = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                dividers.add(i);
                dividers.add(x / i);
            }
        }
        Collections.sort(dividers);
        return dividers;
    }
}
