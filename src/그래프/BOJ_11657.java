package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657 {

    private static long INF = Long.MAX_VALUE;
    private static int N,M;
    private static List<Edge> list;
    private static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드
        M = Integer.parseInt(st.nextToken()); //에지

        dist = new long[N+1];
        list = new ArrayList<Edge>();
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.add(new Edge(A,B,C));
        }

        for (int i = 1; i < N; i++) {
            for (Edge e: list) {
                if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }
        for (Edge e: list) {
            if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i =2; i<=N; i++) {
            if (dist[i] == INF) {
                sb.append(-1);
                sb.append("\n");
            } else {
                sb.append(dist[i]);
                sb.append("\n");
            }
        }
        System.out.println(sb);


    }
    private static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

}
