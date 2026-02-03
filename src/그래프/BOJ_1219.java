package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1219 {
    private static int N,S,E,M;
    private static long[] cityMoney;
    private static List<Edge> edges;
    private static List<Integer>[] A;
    private static long[] dist;
    private static final long MIN = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 수
        S = Integer.parseInt(st.nextToken()); //시작 노드
        E = Integer.parseInt(st.nextToken()); //도착 노드
        M = Integer.parseInt(st.nextToken()); //에지 수

        A = new ArrayList[N];
        edges = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
            A[from].add(to);
        }

        cityMoney = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        dist = new long[N];
        Arrays.fill(dist, MIN);
        dist[S] = cityMoney[S];

        // 벨만–포드
        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == MIN) continue;

                long nextMoney = dist[e.from] - e.cost + cityMoney[e.to];
                if (nextMoney > dist[e.to]) {
                    dist[e.to] = nextMoney;
                }
            }
        }

        //최대 이득 그래프 찾기
        boolean[] cycle = new boolean[N];
        for (Edge e: edges) {
            if (dist[e.from] == MIN) continue;

            long nextMoney = dist[e.from] - e.cost + cityMoney[e.to];
            if (nextMoney > dist[e.to]) {
                cycle[e.to] = true;
            }
        }
        // 그래프 노드에서 도착점 갈 수 있으면 GEE 아니면 gg
        if (pathEnd(cycle)) {
            System.out.println("Gee");
            return;
        }
        if (dist[E] == MIN) {
            System.out.println("gg");
            return;
        }
        System.out.println(dist[E]);

    }

    private static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static boolean pathEnd(boolean[] cycle) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<N; i++) {
            if (cycle[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == E) return true;

            for (int next : A[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}
