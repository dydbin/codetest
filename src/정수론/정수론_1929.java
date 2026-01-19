package 정수론;

import java.io.*;
import java.util.*;


public class 정수론_1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        for (int i = 2; i<=N; i++) {
            A[i]= i;
        }
        for (int i =2; i<=Math.sqrt(N); i++) {
            if(A[i]==0) {
                continue;
            }
            for (int j= i+i;  j<=N; j=j+i) {
                A[j] =0;
            }
        }
        for (int i = M; i<=N; i++) {
            if(A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
