package codeforces.cr345;

import java.util.*;

/**
 * Created by ABiryulin on 3/7/2016.
 */
public class ProblemB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            a.add(x);
        }

        int sum = 0;
        int f = 0;
        int tmp = 0;
        int cnt = 0;
        while (f != a.size()) {
            f = 0;
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < a.size(); i++) {
                tmp = a.get(i);
                if (tmp != -1 && !s.contains(tmp)) {
                    s.add(tmp);
                    a.set(i,-1);
                } else {
                    f++;

                }
            }
            cnt = s.size()-1;
            if (cnt < 0) break;
            sum += cnt;
            if (s.size() == a.size()) break;
            if (s.size() == 1) break;

        }
        System.out.println(sum);


    }
}
