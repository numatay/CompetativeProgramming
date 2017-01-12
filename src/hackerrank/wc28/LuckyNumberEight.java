package hackerrank.wc28;

import java.util.*;

/**
 * Created by umatay on 1/12/17.
 */
public class LuckyNumberEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();

        Map<Integer, List<Integer>> nums3 = new HashMap<>();
        Map<Integer, List<Integer>> nums2 = new HashMap<>();


        for (int i = 0; i < 1000; i++) {
            if (i % 8 == 0) {
                int d1 = i / 100;
                int d2 = (i / 10) % 10;
                if (i < 100) {
                    if (!nums2.containsKey(d2)) {
                        nums2.put(d2, new ArrayList<>());
                    }
                    List<Integer> sortedBag = nums2.get(d2);
                    sortedBag.add(i);
                }
                if (!nums3.containsKey(d1)) {
                    nums3.put(d1, new ArrayList<>());
                }
                List<Integer> sortedBag = nums3.get(d1);
                sortedBag.add(i);
            }
        }

//        System.err.println(nums2);
//        System.err.println(nums3);
        Map<Integer, Long> dummyTuple = new HashMap<>();

        Map<Integer, List> digitsByPos = new HashMap();
        for (int i = 0; i < 10; i++) {
            digitsByPos.put(i, new LinkedList());
        }

        long sum = 0;
        for (int i = n-1; i >= 0; i--) {
            int dig = s.charAt(i) - '0';

            // counting one digit numbers that are divisible by 8
            if (dig == 0 || dig == 8) {
//                System.err.println(">" + dig);
                sum++;
                sum %= (1000000000+7);
            }

            // update reference data structure
            List l = digitsByPos.get(dig);
            l.add(0, i);

            List<Integer> possibleTuples = nums2.get(dig);
            List<Integer> possibleTriples = nums3.get(dig);


//            System.err.println("considering digit " + dig);
//            System.err.println("possilble tuples " + possibleTuples);
//            System.err.println("possible truple " + possibleTriples);



            if (possibleTuples != null) {
                for (Integer tuple : possibleTuples) {
                    long tupleCounter = 0;
                    int tupleRight = (tuple / 10) % 10;
                    int tupleMid = tuple % 10;

                    List<Integer> positionsOfFirst = digitsByPos.get(tupleRight);
                    List<Integer> positionsOfSecond = digitsByPos.get(tupleMid);
//                    System.err.println("compare these lists");
//                    System.err.println(tupleRight + " " + positionsOfFirst);
//                    System.err.println(tupleMid + " " + positionsOfSecond);

                    for (Integer right : positionsOfFirst) {
                        for (Integer mid : positionsOfSecond) {
                            if (right < mid) {
                                tupleCounter++;
//                                System.err.println(">>" + tupleRight + tupleMid);
                            }
                        }
                    }
                    if (tupleCounter != 0)
                        dummyTuple.put(tuple, tupleCounter);
                }

            }


            if (n-i >= 3) {
                for (Integer triple : possibleTriples) {
                    int second = (triple / 10) % 10;
                    int third = triple % 10;

                    List<Integer> positionsOfSecond = digitsByPos.get(second);
                    List<Integer> positionsOfThird = digitsByPos.get(third);
//                    System.err.println("compare these lists");
//                    System.err.println(second + " " + positionsOfSecond);
//                    System.err.println(third + " " + positionsOfThird);


                    for (Integer mid : positionsOfSecond) {
                        for (Integer left : positionsOfThird) {
                            if (mid < left && mid > i) {
                                long toAdd = (1L << i);
//                                System.err.println("sum to add " + toAdd);
                                sum += toAdd;
                                sum %= (1000000000+7);
//                                System.err.println(">>>" + dig + second + third);
                            }
                        }
                    }

//                System.err.println("cnt: " + cnt);
//                System.err.println("--------");
                }
            }

        }

//        System.out.println(nums);
//        System.out.println(digitsByPos);
//        System.err.println("dummyTuple" + dummyTuple);
        for (Long t: dummyTuple.values()) {
            sum += t;
            sum %= (1000000000+7);
        }
        System.out.println(sum);

    }
}
