package hackerrank.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Created by ABiryulin on 2/8/2016.
 */
public class ProblemSolving {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        //PrintWriter wr = new PrintWriter(new FileWriter("path.out"));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        for (int i = 0; i < n; i++) {
            solveTestCase(br);
        }
    }

    public static void solveTestCase(BufferedReader br) throws IOException {
        /* solution */
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        List<Integer> v = new ArrayList<>();
        Set<Integer> in = new HashSet<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, List<Integer>> nodes = new HashMap<>();

        line = br.readLine().split(" ");
        for (String w: line) {
            int x = Integer.parseInt(w);
            v.add(x);
            in.add(x);
            visited.put(x, false);
            nodes.put(x, new ArrayList<Integer>());
        }

        // building an acyclic graph
        for (int i = 0; i < v.size(); i++) {
            Integer uu = v.get(i);
            List<Integer> edges = nodes.get(uu);
            for (int j = i; j < v.size(); j++) {
                Integer vv = v.get(j);
                if (Math.abs(uu - vv) >= k) {
                    edges.add(vv);
                    if (in.contains(vv)) { in.remove(vv); }
                }
            }
        }

        /*
        for (Integer nd: v) {
            System.out.println("Node " + nd + ", edges are " + nodes.get(nd));
        }
        */

        //System.out.print(in.size());
        int days = 0;

        for (Integer curr: v) {
            if (!visited.get(curr)) {
                //System.out.println("Path starting from " + curr + " ***********************");
                visit(curr, visited, nodes);
                days++;
            }
        }

        //visit(v.get(0), visited, nodes);

        System.out.println(days);
    }

    public static void visit(Integer s, Map<Integer, Boolean> visited,  Map<Integer, List<Integer>> nodes) {
        if (s == null) { return; }

        Integer nextSource = null;
        visited.put(s, true);
        List<Integer> edges = nodes.get(s);
        for (int i = 0; i < edges.size(); i++) {
            if (!visited.get(edges.get(i))) {
                nextSource = edges.get(i);
                break;
            }
        }
        //System.out.println("Traversing from " + s + " to " + nextSource);
        visit(nextSource, visited, nodes);
    }
}
