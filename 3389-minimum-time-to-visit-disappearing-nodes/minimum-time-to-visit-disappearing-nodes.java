import java.util.*;

class Solution {

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<Pair<Integer,Integer>>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // Populate adjacency list with edges
        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair<>(e[1], e[2]));
            adj.get(e[1]).add(new Pair<>(e[0], e[2]));
        }

        // Initialize distances array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Initialize priority queue
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        pq.offer(new Pair<>(0, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair<Integer,Integer> p = pq.poll();
            int u = p.getKey();
            int d = p.getValue();

            if (d>dist[u]) continue;

            for (Pair<Integer,Integer> pr : adj.get(u)) {
                int v = pr.getKey();
                int edgeWeight = pr.getValue();
                int disappearTime = disappear[v]; 

                if (dist[v] > dist[u] + edgeWeight && dist[u] + edgeWeight < disappearTime) {
                    dist[v] = dist[u] + edgeWeight;
                    pq.offer(new Pair<>(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }
}
