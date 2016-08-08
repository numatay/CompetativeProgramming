package leetcode.problem380;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> hm;
    private List<Integer> lst;
    private Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.hm = new HashMap<>();
        this.lst = new ArrayList<>();
        this.rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hm.containsKey(val)) {
            hm.put(val, hm.size());
            lst.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hm.containsKey(val)) {
            int idxDel = hm.get(val);
            int idxRep = hm.get(lastElem(lst));
            hm.remove(val);
            replaceWithDelete(lst, idxDel, idxRep);
            if (idxDel != lst.size())
                hm.put(lst.get(idxDel), idxDel);

            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return lst.get(rnd.nextInt(hm.size()));
    }

    private static int lastElem(List<Integer> l) {
        return l.get(l.size() - 1);
    }

    private static void replaceWithDelete(List<Integer> l, int x, int y) {
        if (x != y) {
            l.set(x, l.get(y));
            l.remove(y);
        } else {
            l.remove(y);
        }
    }
}
