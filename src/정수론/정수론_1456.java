package 정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수론_1456 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = (int)Math.sqrt(B);

        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (max >=1) isPrime[1] = false;

        for (int i = 2; i*i <= max; i++) {
            if(isPrime[i]) {
                for (int j = i*i; j <=max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        long count = 0;

        for (int i=2; i<=max; i++) {
            if (!isPrime[i]) continue;

            long value = (long)i*i;
            while (value <= B) {
                if (value >= A) {
                    count++;
                }
                if (value > (B / i)) break;

                value *= i;
            }
        }
        System.out.println(count);
    }
}
