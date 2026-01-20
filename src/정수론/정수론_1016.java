package 정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론_1016 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] A = new boolean[(int) (max-min +1)];

        for (long i = 2; i*i<= max; i++) {
            long k = i*i;
            long start = min / k;
            if (min % k != 0) {
                start++;
            }
            for(long j = start; k*j <= max; j++) { // j는 계수,
                A[(int) ((j*k)-min)] = true;
            }
        }
        int count = 0;
        for (int i=0; i<=max-min; i++) {
            if(!A[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
