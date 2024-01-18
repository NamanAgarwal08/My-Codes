import java.util.*;

public class kruskals {

    static class Edge implements Comparable<Edge> {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    
    static int n = 4; // number of vertices
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        // return find(par[x]);
        return par[x] = find(par[x]); // path compression optimization in Union Find.
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    // O(V + ElogE)
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges); // O(ElogE)
        int mstCost = 0;
        int count = 0; // number of edges included

        for (int i = 0; count < V - 1; i++) { //O(V)
            Edge e = edges.get(i);
            //(src,des,wt)

            int parA = find(e.src); // src = a
            int parB = find(e.des); // des = b
            if (parA != parB) {
                union(e.src, e.des);
                mstCost += e.wt;
                count++;
            }
        }
        
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
