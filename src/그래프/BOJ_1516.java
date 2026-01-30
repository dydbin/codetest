package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516 {
    private static ArrayList<Integer>[] A;
    private static int[] D; // 차수 저장
    private static int[] T; //건물 마다 걸리는 시간
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 건물 종류 수

        A = new ArrayList[N+1];
        D = new int[N+1];
        T = new int[N+1];
        result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            D[i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            T[i] = a;
            while (true) {
                int p = Integer.parseInt(st.nextToken());
                if (p == -1) break;
                A[p].add(i);
                D[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A[now]) {
                D[next]--;
                result[next] = Math.max(result[next], result[now]+T[now]);
                if (D[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]+T[i]);
        }

    }
}
