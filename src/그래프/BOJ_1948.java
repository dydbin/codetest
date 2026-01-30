package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1948 {

    private static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private static class REdge {
        int from, weight;
        REdge(int from, int weight) {
            this.from = from;
            this.weight = weight;
        }
    }

    private static List<Edge>[] graph;
    private static List<REdge>[] reverse;
    private static int[] D;    //차수
    private static int[] dist; //거리
    private static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  //노드
        M = Integer.parseInt(br.readLine());  //간선

        graph = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        D = new int[N+1];
        dist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            reverse[v].add(new REdge(u, w));
            D[v]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Edge e : graph[now]) {
                int next = e.to;
                int w = e.weight;

                if (dist[next] < dist[now] + w) {
                    dist[next] = dist[now] + w;
                }
                D[next]--;
                if (D[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(dist[end]); //최장 시간

        //역그래프 임계 간선 개수
        boolean[] visited = new boolean[N+1];
        Queue<Integer> rq = new LinkedList<>();
        rq.offer(end);
        visited[end] = true;

        int count = 0;
        while (!rq.isEmpty()) {
            int now = rq.poll();
            for (REdge e : reverse[now]) {
                int prev = e.from;
                int w = e.weight;
                if (dist[prev] + w == dist[now]) {
                    count++;
                    if (!visited[prev]) {
                        visited[prev] = true;
                        rq.offer(prev);
                    }
                }

            }
        }
        System.out.println(count);
    }
}
