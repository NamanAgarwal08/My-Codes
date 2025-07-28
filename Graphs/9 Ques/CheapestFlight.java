// Cheapest Flight within K stops.

// There are n cities connected by some number of flights. You are given an array flights where
// flights[i] = [from, to, price] indicates that there is a flight.
// You are also given three integers src, dst, and k, return the cheapest price from src to dst with atmost k stops.
// If there is no such route. return -1

//Note L all values are positive
import java.util.*;

public class CheapestFlight {
    
    static class Edge {
        int src;
        int des;
        int cost;

        public Edge(int src, int des, int cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }

    }
    
    public static int cheapestFlight(int n, int flights[][], int src, int des, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.des;
                int wt = e.cost;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        
        //dist[des]
        if (dist[des] != Integer.MAX_VALUE) {
            return dist[des];
        } else {
            return -1;
        }
    }
    
    static class Info {
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of airports : ");
        int n = sc.nextInt();

        System.out.print("Enter number of flights : ");
        int f = sc.nextInt();

        int flights[][] = new int[f][3];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < 3; j++) {
                flights[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source : ");
        int src = sc.nextInt();

        System.out.print("Enter destination : ");
        int dst = sc.nextInt();

        System.out.print("Enter maximum stops in between : ");
        int k = sc.nextInt();

        System.out.println(cheapestFlight(n, flights, src, dst, k));

    }
}