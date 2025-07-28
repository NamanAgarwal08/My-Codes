import java.util.*;

public class bipartite {

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // O(V+E)
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
            // -1 refers to no color
            //  0 refers to some color
            //  1 refers to some other color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // case-3
                        if (color[e.des] == -1) {
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.des] = nextCol;
                            q.add(e.des);
                        }

                        // case-2 
                        // (color[e.des] != color[curr]) => do nothing

                        // case-1
                        else if (color[e.des] == color[curr]) {
                            return false; // NOT bipartite
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
            // if graph doesn't contains cycle -> Always BIPARTITE
            //     0--------2
            //    /        /
            //   /        /
            //  1        4
            //   \      /
            //    \    / 
            //     \  /
            //       3

            int V = 5;
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            System.out.println(isBipartite(graph));
    }

}