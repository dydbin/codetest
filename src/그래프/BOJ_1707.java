package 그래프;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {

    private static ArrayList<Integer>[] A;
    private static int N, V, E;
    private static boolean[] visited;
    private static int[] check;
    private static boolean isEven;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); //정점
            E = Integer.parseInt(st.nextToken()); //에지
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start);
            }
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && isEven) {
                    DFS(j);
                }
            }
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    private static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
