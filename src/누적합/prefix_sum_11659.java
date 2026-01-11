package 누적합;

import java.util.*;
import java.io.*;

public class prefix_sum_11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) {
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int k=0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(prefix[j] - prefix[i-1]);
        }
    }
}

/*
수 N개가 주어졌을 때, i부터 j까지 수의 합
int N <- 수의 개수
int M <- 합을 구해야하는 횟수
두번째 줄
 */