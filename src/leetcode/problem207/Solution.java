package leetcode.problem207;

import java.util.*;

/**
 * Created by Nurgissa on 4/12/2016.
 */
public class Solution {
    public static void main(String[] args) {
        int n = 1;
        int[][] preqs = {};

        Solution sol = new Solution();
        System.out.print(sol.canFinish(n, preqs));

    }

    public boolean canFinish(int numCourses, int[][] prereq) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int u, v;

        for (int i = 0; i < prereq.length; i++) {
            u = prereq[i][0];
            v = prereq[i][1];
            List<Integer> e;
            if (!g.containsKey(u)) {
                e = new ArrayList<>();
                g.put(u, e);
            }
            e = g.get(u);
            e.add(v);
            g.put(u, e);
        }

        int visited[] = new int[numCourses];
        int finished[] = new int[numCourses];

        Iterator<Integer> it = g.keySet().iterator();
        for (int i = 0; i < numCourses; i++)
            dfs(i, g, visited, finished);

        for (int i: finished) {
            if (i == -1) return false;
        }

        return true;
    }

    private static void dfs(int u, Map<Integer, List<Integer>> g, int[] visited, int finished[]) {
        if (visited[u] == 0) {
            visited[u] = 1;

            List<Integer> vs = g.get(u);
            if (vs != null) {
                for (int i = 0; i < g.get(u).size(); i++) {
                    int v = g.get(u).get(i);
                    dfs(v, g, visited, finished);
                }
            }
            // update finish if and only if we have not finished the vertex
            if (finished[u] == 0)
                finished[u] = 1;
        } else if (visited[u] == 1 && finished[u] != 1) {
            // cycle detected
            finished[u] = -1;
        }
    }
}