package leetcode.problem205;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nurgissa on 5/25/2016.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return getSign(s) == getSign(t);
    }
    private static long getSign(String s) {
        Map<Character, Long> hm = new HashMap<>();
        long counter = 1, sum = 0, tick = 1;
        for (int i = 0; i < s.length(); i++, tick++) {
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), counter);
                counter++;
            }
            sum += (hm.get(s.charAt(i))*tick);
        }
        return sum;
    }
}
