import java.util.*;

public class Graph {

    static class Edge {
        int src; // source
        int des; // destination
        int wt; // weight

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    // public static void main(String args[]) {
    //     //      (5)
    //     //   0-------1
    //     //       (1)/ \(3)
    //     //         /   \
    //     //        2-----3
    //     //        | (1)
    //     //     (2)|
    //     //        |
    //     //        4

    //     int V = 5; // number of vertices in graph
    //     ArrayList<Edge> graph[] = new ArrayList[V]; // by default null is stored at each index
    //     for (int i = 0; i < V; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     //0-vertex
    //     graph[0].add(new Edge(0, 1, 5));

    //     //1-vertex
    //     graph[1].add(new Edge(1, 0, 5));
    //     graph[1].add(new Edge(1, 2, 1));
    //     graph[1].add(new Edge(1, 3, 3));

    //     //2-vertex
    //     graph[2].add(new Edge(2, 1, 1));
    //     graph[2].add(new Edge(2, 3, 1));
    //     graph[2].add(new Edge(2, 4, 2));

    //     //3-vertex
    //     graph[3].add(new Edge(3, 1, 3));
    //     graph[3].add(new Edge(3, 2, 1));

    //     //4-vertex
    //     graph[4].add(new Edge(4, 2, 2));

    //     //2's Neighbours
    //     for (int i = 0; i < graph[2].size(); i++) {
    //         Edge e = graph[2].get(i);
    //         System.out.println(e.des);
    //     }

    // }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }


    // bfs is like level order traversal in trees
    public static void bfs(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited, i);
            }
        }
        
        System.out.println();
    }

    public static void bfsUtil(ArrayList<Edge> graph[],boolean visited[],int ele) { // O(V+E) (for adjacency implementation)|| O(V^2) (for matrix implementation) [V -> Vertices , E -> Egdes]
        Queue<Integer> q = new LinkedList<>();
        q.add(ele);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }


    //dfs is done using recursive function (which uses a Stack(call stack) implicitly)
    public static void dfs(ArrayList<Edge> graph[]) {
        
        boolean visited[] = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }

        System.out.println();

    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]) { // O(V+E)
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if (!visited[graph[curr].get(i).des]) {
                dfsUtil(graph, graph[curr].get(i).des, visited);
            }
        }
    }


    // Has Path?
    // for given src and des, tell if a path exists from src to des
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int des, boolean visited[]) { // O(V+E)
        if (src == des) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.des] && hasPath(graph, e.des, des, visited)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]) {
        //     1---------3
        //    /          | \
        //   0           |  5-----6
        //    \          | /
        //     2---------4

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bfs(graph);
        
        dfs(graph);
        
        System.out.println(hasPath(graph, 0, 7, new boolean[V]));

    }
}