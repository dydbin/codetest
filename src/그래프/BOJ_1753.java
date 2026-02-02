package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    private static ArrayList<Node>[] A;
    private static int[] dist;
    private static PriorityQueue<Node> queue;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        A = new ArrayList[V+1];
        dist = new int[V+1];
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i =1; i<=V; i++){
            A[i] = new ArrayList<Node>();
        }
        for (int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[a].add(new Node(b,c));
        }
        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);



    }
    private static class Node implements Comparable<Node> {
        int value, weight;
        Node (int v, int w) {
            this.value = v;
            this.weight = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        dist[start] = 0;
        q.offer(new Node(start,0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int now = cur.value;
            int cost = cur.weight;

            if (dist[now] < cost) { continue;}
            for (Node next : A[now]) {
                int newCost = dist[now] + next.weight;
                if (newCost < dist[next.value]) {
                    dist[next.value] = newCost;
                    q.offer(new Node(next.value, newCost));
                }
            }
        }
    }
}
