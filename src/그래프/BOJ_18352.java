package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {

    private static int[] visited;
    private static ArrayList<Integer>[] graph;
    private static int N,M,K,X;
    private static List<Integer> answer;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        K = Integer.parseInt(st.nextToken()); //최단 거리
        X = Integer.parseInt(st.nextToken()); //출발 노드

        graph = new ArrayList[N+1];
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        visited = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int temp: answer) {
                System.out.println(temp);
            }
        }

    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = 0;
        while ( !queue.isEmpty()) {
            int nNode = queue.poll();
            for (int i  : graph[nNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nNode] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
