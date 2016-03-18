package codeforces.croc2016q;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nurgissa on 3/18/2016.
 */
public class ProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String line = br.readLine();
        int n = Integer.parseInt(line);

        for (int i = 0; i < n; i++) {
            //line = br.readLine();

        }

        SimpleTrie trie = new SimpleTrie();


        String path = "http://ccc.bbbb";
        trie.insert(path);

        path = "http://ccc.bbbb/aba..b";
        trie.insert(path);

        path = "http://ccc.bbbb/";
        trie.insert(path);

        path = "a.a.a/ab/dc/as/";
        trie.insert(path);


        trie.printTrie();

        System.out.println();
    }


}

class SimpleTrie {
    private Node root;

    public SimpleTrie() {
        this.root = new Node();
    }

    public List<Long> getSignatures() {
        throw new NotImplementedException();
    }

    public void insert(String fullPath) {
        List<String> p = SimpleTrie.parsePath(fullPath);
        insert(root, p, 0);
    }

    private void insert(Node cur, List<String> path, int idx) {
        if (idx == path.size()) {
            // end of the word
            Node terminalNode = new Node("$", cur.getLevel()+1);
            terminalNode.terminal = true;
            cur.children.add(terminalNode);
        } else {
            String word = path.get(idx);
            // exist such word
            for (Node child : cur.children) {
                if (child.getWord().equals(word)) {
                    insert(child, path, ++idx);
                    return;
                }
            }

            // new word
            Node childNode = new Node(word, cur.getLevel()+1);
            cur.children.add(childNode);
            insert(childNode, path, ++idx);
        }
    }

    public String printShortestTrie(Node cur, StringBuilder sb) {

        return sb.toString();
    }

    public void printTrie() {
        printTrie(root);
    }

    private void printTrie (Node root) {
        if (root == null) {
            System.out.println();
        } else {
            if (root.isTerminal()) {
                System.out.println();
                System.out.print(root.getWord() + "|_");
            } else {
                System.out.print(root.getWord() + "->");
                for (Node child : root.children) {
                    printTrie(child);
                }
            }
        }
    }

    public static List<String> parsePath(String path) {
        String[] words = path.split("/");
        List<String> lst = new LinkedList<>(Arrays.asList(words));
        if (path.endsWith("/")) { lst.add("/"); }
        return lst;
    }


    class Node {
        private List<Node> children;
        private long signature = 0;
        private String word = null;
        private int level;
        private int count = 0;
        private boolean terminal = false;

        // terminal node
        public Node() {
            level = 0;
            this.children = new ArrayList<>();
        }

        public Node(boolean terminal, int level) {
            this.terminal = terminal;
            this.level = level;
            this.children = new ArrayList<>();
        }

        public Node(String word, int level) {
            this.children = new ArrayList<>();
            this.level = level;
            this.word = word;
        }


        public void setLevel(int level) { this.level = level; }
        public int getLevel() { return this.level; }

        public String getWord() { return this.word; }
        public boolean isTerminal() { return this.terminal; }

        public int hashCode() {
            return Objects.hash(this.word, this.level);
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Node)) return false;
            if (((Node) o).getWord().equals(this.getWord())) {
                return true;
            } else {
                return false;
            }
        }
    }
}