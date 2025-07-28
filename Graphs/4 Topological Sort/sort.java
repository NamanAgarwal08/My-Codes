import java.util.* ;

public class sort {

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    
    // USING DFS
    public static void topologicalSortDFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stk); // modified DFS
            }
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

        System.out.println();
    }

    // O(V+E) 
    // FOR DFS
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stk) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                topSortUtil(graph, e.des, vis, stk);
            }
        }

        stk.add(curr);
    }


    public static void calcIndegree(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.des]++;
            }
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.des]--;
                if (indeg[e.des] == 0) {
                    q.add(e.des);
                }
            }
        }
        
        System.out.println();
    }
    
    public static void main(String args[]) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        topologicalSortDFS(graph);

        topologicalSortBFS(graph);

    }
}
