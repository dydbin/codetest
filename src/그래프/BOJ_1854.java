package 그래프;

import java.io.*;
import java.security.Key;
import java.util.*;

public class BOJ_1854 {
    private static PriorityQueue<Edge> pq;
    private static PriorityQueue<Integer>[] dist;
    private static List<Edge>[] A;
    private static int n,m,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //도시 개수
        m = Integer.parseInt(st.nextToken()); //도시 간선 수
        k = Integer.parseInt(st.nextToken()); //k번째 최단 경로

        A = new ArrayList[n+1];
        dist = new PriorityQueue[n+1];
        for (int i = 1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i =1; i<=n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Edge(v, w));
        }
        dijkstra(1);
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i].peek());
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

    private static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        dist[start].offer(0);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.to;
            int cost = e.weight;

            if (dist[now].size() == k && dist[now].peek() < cost) {
                continue;
            }
            for (Edge next : A[now]) {
                int newCost = cost + next.weight;

                if (dist[next.to].size() < k) {
                    dist[next.to].offer(newCost);
                    pq.offer(new Edge(next.to, newCost));
                }
                else if (dist[next.to].peek() > newCost) {
                    dist[next.to].poll();
                    dist[next.to].offer(newCost);
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }
}
