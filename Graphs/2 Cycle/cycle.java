import java.util.*;

public class cycle {
    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    //UNDIRECTED GRAPH
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // DETECT CYCLE CODE FOR UNDIRECTED GRAPH
    // O(V+E)
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case-3
            if (!vis[e.des]) {
                if (detectCycleUtil(graph, vis, e.des, curr)) {
                    return true;
                }
            }

            // case1
            else if (vis[e.des] && e.des != par) {
                return true;
            }

            // case-2 : do nothing -> continue [vis[e.des] && e.des == par]
        }
        return false;
    }

    
    //DIRECTED GRAPH
    public static void createGraph2(ArrayList<Edge> graph2[]) {
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0, 2));

        graph2[1].add(new Edge(1, 0));

        graph2[2].add(new Edge(2, 3));

        graph2[3].add(new Edge(3, 0));

    }
    
    //DETECT CYCLE CODE FOR DIRECTED GRAPH
    // O(V+E)
    public static boolean detectCycle2(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycle2Util(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public static boolean detectCycle2Util(ArrayList<Edge> graph[], int curr, boolean vis[],boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;// iska mtlb ki abhi jo recursion waala stack chal rha hai usme curr Node hai
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case-1
            if (stack[e.des]) { // cycle
                return true;
            }

            //case-2
            // if(vis[e.des]) => do nothing

            //case-3
            else if (!vis[e.des] && detectCycle2Util(graph, e.des, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        //        0------------3
        //      / |            |
        //    /   |            |
        //   1    |            4
        //    \   |
        //     \  |
        //       2

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));

        int V2 = 4;
        ArrayList<Edge> graph2[] = new ArrayList[V2];
        createGraph2(graph2);
        System.out.println(detectCycle2(graph2));


    }
}
