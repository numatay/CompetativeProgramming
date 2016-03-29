package learn5minutes.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurgissa on 3/29/2016.
 */
public class StronglyConnectedComponents {
    public static void main(String[] args) {
    }


    static class DiGraph {
        private int v;
        private int[][] vertices;

        public DiGraph(int v) {
            this.v = v;
            this.vertices = new int[v][v];
        }

        public void addEdge(int u, int v) {
            this.vertices[u][v] = 1;
        }

        public int[] getVertices(int u) {
            List<Integer> edges = new ArrayList<>();
            for (int v: this.vertices[u]) {
                if (this.vertices[u][v] != 0) edges.add(v);
            }
            return edges.stream().mapToInt(i->i).toArray();
        }

        public int[][] transposeGraph() {
            int[][] tg = new int[this.v][this.v];
            for (int i = 0; i < this.v; i++)
                for (int j = 0; j < this.v; j++)
                    tg[i][j] = this.vertices[j][i];
            return tg;
        }

    }


}
