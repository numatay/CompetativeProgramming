package leetcode.problem344;

/**
 * Created by Nurgissa on 5/16/2016.
 */
public class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        for ( int l = 0, r = str.length-1; l < r; str[l] ^= str[r], str[r] ^= str[l], str[l++] ^= str[r--]) { }
        return new String(str);
    }
}
