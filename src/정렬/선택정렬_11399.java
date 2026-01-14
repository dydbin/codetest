package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선택정렬_11399 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int prefix = 0;
        int[] A = new int[N];
        for (int i = 0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<N-1; i++) {
            int minIndex = i;

            for (int j = i+1; j <N; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
        for (int i=0; i<N; i++) {
            prefix += A[i];
            sum += prefix;
        }
        System.out.println(sum);
    }
}
