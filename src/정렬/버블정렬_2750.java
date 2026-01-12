package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블정렬_2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] swap = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            swap[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (swap[j] > swap[j+1]) {
                    int temp = swap[j+1];
                    swap[j+1] = swap[j];
                    swap[j] = temp;
                }
            }
        }
        for (int i =0; i<N; i++) {
            System.out.println(swap[i]);
        }

    }
}
