package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_17472 {
    private static int N, M;
    private static int[][] map;
    private static int[][] land;
    private static int K; // 섬 개수
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[] parent, rank;

    private static class Edge implements Comparable<Edge>{
        int to,from,value;
        Edge(int to, int from, int value){
            this.to = to;
            this.from = from;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        land = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 1) 섬 라벨링
        K = label();

        // 2) 가능한 다리(간선) 만들기
        List<Edge> edges = buildEdges();

        // 3) MST(크루스칼)
        int answer = kruskal(edges);

        System.out.println(answer);
    }

    //Bfs로 섬 번호
    private static int label() {
        int id = 0;
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    id ++;
                    visited[r][c] = true;
                    land[r][c] = id;

                    queue.add(new int[]{r, c});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cr = cur[0];
                        int cc = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) { continue;}
                            if (visited[nr][nc]) { continue;}
                            if (map[nr][nc] == 0) {continue;}
                            visited[nr][nc] = true;
                            land[nr][nc] = id;

                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
            }
        }
        return id;
    }
    private static List<Edge> buildEdges() {
        int INF = Integer.MAX_VALUE;
        int[][] minWeight = new int[K+1][K+1];
        for (int i = 1; i <= K; i++) {
            Arrays.fill(minWeight[i], INF);
        }
        for (int r = 0; r < N; r++) {
            for  (int c = 0; c < M; c++) {
                if (land[r][c] == 0) {continue;}
                int from = land[r][c];

                for (int d =0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) { continue;}
                    if (land[nr][nc] != 0) { continue; }
                    int len = 0;

                    while (nr >= 0 && nr < N && nc >= 0 && nc < M && land[nr][nc] == 0) {
                        len++;
                        nr += dr[d];
                        nc += dc[d];
                    }

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                    int to = land[nr][nc];
                    if (to != 0 && to != from && len >= 2) {
                        if (len < minWeight[from][to]) {
                            minWeight[from][to] = len;
                            minWeight[to][from] = len;
                        }
                    }
                }
            }
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            for (int j = i + 1; j <= K; j++) {
                if (minWeight[i][j] < INF) edges.add(new Edge(i, j, minWeight[i][j]));
            }
        }
        return edges;
    }
    // 크루스칼 MST
    static int kruskal(List<Edge> edges) {
        Collections.sort(edges);
        initDSU(K);

        int used = 0;
        int total = 0;

        for (Edge e : edges) {
            if (union(e.to, e.from)) {
                total += e.value;
                used++;
                if (used == K - 1) break;
            }
        }

        return (used == K - 1) ? total : -1;
    }

    // DSU
    static void initDSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA == rootB) return false;

        if (rank[rootA] < rank[rootB]) parent[rootA] = rootB;
        else if (rank[rootA] > rank[rootB]) parent[rootB] = rootA;
        else { parent[rootB] = rootA; rank[rootA]++; }

        return true;
    }

}
