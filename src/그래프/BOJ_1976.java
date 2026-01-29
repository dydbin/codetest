package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_1976 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int first = find(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) != first) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    private static int find(int x) {
        if (parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        parent[rootB] = rootA;
    }
}

/**
 * 도시의 수  N <= 200
 * 여행 계획 속한 도시 : M <= 1000
 * N개의 줄에는 N개의 정수가 주어짐.
 */