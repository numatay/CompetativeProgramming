package hackerrank.graphs.strings;

import java.util.*;
/**
 * Created by @umatayn on 9/21/2016.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int counter = 1;
        for (char c: s.toCharArray()) {
            counter += (Character.isUpperCase(c) ? 1 : 0);
        }
        System.out.println(counter);
    }
}
