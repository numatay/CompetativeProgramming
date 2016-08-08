package leetcode.problem380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private Map<Integer, Integer> hm;
    private List<Integer> lst;
    private java.util.Random rnd;
    private int count;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.hm = new HashMap<>();
        this.lst = new ArrayList<>();
        this.rnd = new java.util.Random();

        this.count = 0;
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
            if (hm.size() == 1) {
                hm.clear();
                lst.clear();
            } else {
                int idxDel = hm.get(val);
                int idxRep = hm.get(lastElem(lst));
                hm.remove(val);
                replaceWithDelete(lst, idxDel, idxRep);
                if (idxDel != lst.size()) hm.put(lst.get(idxDel), idxDel);
            }
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
        l.add(x, l.get(y));
        l.remove(y);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();

        /*
        ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        [[],[1],[2],[2],[],[1],[2],[]]
        */

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */