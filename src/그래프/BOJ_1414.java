package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_1414 {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();
        long totalLength = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int len = charToLength(line.charAt(j));
                totalLength += len;

                if (len > 0 && i != j) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }

        Collections.sort(edges);

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        long mstLength = 0;
        int count = 0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                mstLength += e.weight;
                count++;

                if (count == N - 1) break;
            }
        }

        // 모든 컴퓨터가 연결되지 않은 경우
        if (count != N - 1) {
            System.out.println(-1);
        } else {
            System.out.println(totalLength - mstLength);
        }
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
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }

    private static int charToLength(char c) {
        if ('a' <= c && c <= 'z') return c - 'a' + 1;
        if ('A' <= c && c <= 'Z') return c - 'A' + 27;
        return 0;
    }

}