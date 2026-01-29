package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
    private static int[] parent;
    private static ArrayList<Integer>[] party;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st= new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int[] truth = new int[K];
        for (int i = 0; i < K; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            party[i].add(first);

            for (int j = 1; j < a; j++) {
                int x = Integer.parseInt(st.nextToken());
                party[i].add(x);
                union(first,x);
            }
        }

        boolean[] truthRoot = new boolean[N+1];
        for (int t : truth) {
            truthRoot[find(t)] = true;
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean t = true;
            for (int j : party[i]) {
                if (truthRoot[find(j)]) {
                    t = false;
                    break;
                }
            }
            if (t) { answer++; }
        }
        System.out.println(answer);




    }
    private static int find(int x) {
        if (parent[x] == x) return x;
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
