package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max0 = a, max1 = b, max2 = c;
        int min0 = a, min1 = b, min2 = c;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int nextMax0 = Math.max(max0,max1) + a;
            int nextMax1 = Math.max(Math.max(max0,max1),max2) + b;
            int nextMax2 = Math.max(max1,max2) + c;

            int nextmin0 = Math.min(min0,min1) + a;
            int nextmin1 = Math.min(Math.min(min0,min1),min2) + b;
            int nextmin2 = Math.min(min1,min2) + c;

            max0 = nextMax0;
            max1 = nextMax1;
            max2 = nextMax2;

            min0 = nextmin0;
            min1 = nextmin1;
            min2 = nextmin2;
        }
        int maxAnswer = Math.max(Math.max(max0,max1),max2);
        int minAnswer = Math.min(Math.min(min0,min1),min2);

        System.out.println(maxAnswer + " " +  minAnswer);

    }
}
