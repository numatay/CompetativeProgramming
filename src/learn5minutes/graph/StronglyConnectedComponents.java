package learn5minutes.graph;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

/**
 * Created by Nurgissa on 3/29/2016.
 */
public class StronglyConnectedComponents {
    public static void main(String[] args) {
        int n = 6;
        DiGraph g = new DiGraph(6);
        // 0
        g.addEdge(0,1);
        g.addEdge(0,2);
        // 1
        g.addEdge(1,2);
        // 2
        g.addEdge(2,3);
        g.addEdge(2,4);
        // 3
        g.addEdge(3,5);
        // 4
        g.addEdge(4,5);
        g.addEdge(4,1);
        // 5
        g.addEdge(5,3);

        List<Integer> sorted = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(g, i, visited, sorted);
        }
        System.out.print(sorted);
        g.printGraph();

        visited = new boolean[n];
        g.transposeGraph();
        g.printGraph();
        List<List<Integer>> components = new ArrayList<>();

        for (Integer node: sorted) {
            List<Integer> cmp = new ArrayList<>();
            dfs(g, node, visited, cmp);
            if (!cmp.isEmpty())
                components.add(cmp);
        }
        System.out.println(components);
    }

    private static void dfs(DiGraph g, int u, boolean[] visited, List<Integer> sorted) {
        if (!visited[u]) {
            visited[u] = true;
            int[] vs = g.getVertices(u);
            for (int v: vs) {
                dfs(g, v, visited, sorted);
            }
            sorted.add(0, u);
        }
    }



    static class DiGraph {
        private int[][] vertices;

        public DiGraph(int v) {
            this.vertices = new int[v][v];
        }

        public void addEdge(int u, int v) {
            this.vertices[u][v] = 1;
        }

        public int[] getVertices(int u) {
            List<Integer> edges = new ArrayList<>();
            for (int j = 0; j < this.vertices[u].length; j++) {
                if (this.vertices[u][j] != 0) edges.add(j);
            }
            return edges.stream().mapToInt(i->i).toArray();
        }

        public void transposeGraph() {
            int n = this.vertices.length;
            int[][] tg = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    tg[i][j] = this.vertices[j][i];
            this.vertices = tg;
        }

        public void printGraph() {
            System.out.println("\n**Printing Graph**");
            for (int i = 0; i < this.vertices.length; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < this.vertices.length; j++) {
                    if(this.vertices[i][j] == 1)
                        System.out.print(j + ", ");
                }
                System.out.println();
            }
        }
    }


}
