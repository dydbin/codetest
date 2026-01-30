package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    private static ArrayList<Integer>[] A;
    private static int[] D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        D = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            D[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now+" ");
            for (int next : A[now]) {
                D[next]--;
                if (D[next] == 0) {
                    queue.offer(next);
                }
            }
        }


    }
}
