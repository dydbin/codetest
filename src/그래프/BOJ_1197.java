package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

    private static int N,M;
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }
        Collections.sort(edges);

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        long weight = 0;
        int count = 0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                weight += e.weight;
                count++;

                if (count == N -1)  break;
            }
        }

        System.out.println(weight);
    }

    private static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private static boolean union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);

        if (rootA == rootB) { return false; }
        parent[rootB] = rootA;
        return true;
    }
}
