package 탐색;

import java.io.*;
import java.util.*;

public class 이진탐색_1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = A.length-1;
            while (start <= end) {
                int mid = (start + end) / 2;  // 인덱스
                int midT = A[mid];
                if (midT > target) {
                    end = mid -1;
                } else if (midT < target) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            } if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
