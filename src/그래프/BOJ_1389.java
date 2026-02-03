package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    private static int[][] dist;
    private static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i==j) dist[i][j] = 0;
                else dist[i][j] = 1000000;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
            dist[B][A] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k]+dist[k][j]) {
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int MAX = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                temp += dist[i][j];
            }
            if (MAX > temp) {
                MAX = temp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
