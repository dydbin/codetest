package 정수론;
//오일러 피

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정수론_11689 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long count = N;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                count = count - count/i;
                while (N % i ==0) {
                    N /= i;
                }
            }
        }
        if (N > 1) {
            count = count - count / N;
        }
        System.out.println(count);
    }
}
