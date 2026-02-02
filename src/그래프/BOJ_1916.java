package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    private static List<Edge>[] A;
    private static int[] dist;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            A[start].add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Dijkstra(start, end);
        System.out.println(dist[end]);

    }
    private static void Dijkstra(int start, int end) {
        pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.to;
            int cost = e.weight;

            if (dist[now] < cost) {
                continue;
            }
            for (Edge next : A[now]) {
                int newCost = dist[now] + next.weight;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
