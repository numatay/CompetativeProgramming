package codeforces.cr345;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by ABiryulin on 3/7/2016.
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> xs = new HashMap<>();
        Map<Integer, Integer> ys = new HashMap<>();
        Map<Pair, Integer> sum = new HashMap<>();

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            y = in.nextInt();

            if (!xs.containsKey(x)) {
                xs.put(x, 1);
            } else {
                xs.put(x, xs.get(x)+1);
            }
            if (!ys.containsKey(y)) {
                ys.put(y, 1);
            } else {
                ys.put(y, ys.get(y)+1);
            }
            Pair p = new Pair(x, y);
            if (!sum.containsKey(p)) {
                sum.put(p, 1);
            } else {
                sum.put(p, sum.get(p)+1);
            }

        }

        long cntX = 0;
        for (Integer val: xs.values()) {
            cntX += cn2(val);
        }
        long cntY = 0;
        for (Integer val: ys.values()) {
            cntY += cn2(val);
        }
        long cntSum = 0;
        for (Integer val: sum.values()) {
            cntSum += cn2(val);
        }

        long cnt = cntX + cntY - cntSum;


        System.out.println(cnt);
    }

    public static long cn2(int n) {
        long sum = 1;
        for (int i = n; i > n-2; i--) {
            sum *= i;
        }
        return sum/2;
    }
}

class Pair {
    public int a;
    public int b;

    public Pair() {
        new NoSuchMethodException();
    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b);
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        if (this.a == p.a && this.b == p.b) { return true; }
        else { return false; }
    }
}
