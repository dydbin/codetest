package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_1717 {
    private static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //집합에 들어갈 원소 개수
        int m = Integer.parseInt(st.nextToken()); //입력 연산 개수
        A = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            A[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int bin = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (bin == 0) {
                union(a, b);
            } else if (bin == 1) {
                find(a);
                find(b);
                if (find(a) == find(b)) {
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static int find(int x) {
        if (A[x] == x) return x;
        return A[x] = find(A[x]);
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }
        A[rootB] = rootA;

    }
}
/**
 * 배열 A
 * A[0] <- 0 또는 1인지 확인
 * 0이면 0 a b 집합을 하나의 집합으로 합침 (a, b) <- 유니온 파인드
 * 1이면 같은 집합인지 확인
 *
 */