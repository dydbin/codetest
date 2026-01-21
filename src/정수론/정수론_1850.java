package 정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론_1850 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = gcd(A,B);
        while (result > 0) {
            sb.append('1');
            result--;
        }
        System.out.println(sb);

    }
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}
