package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 그리디_1715 {
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        A = new int[N];

        for (int i = 0; i<N; i++) {
            int data = Integer.parseInt(br.readLine());
            pq.add(data);
        }
        int data1 = 0;
        int data2 = 0;
        int sum =0;

        while (pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1+data2);
        }
        System.out.println(sum);

    }
}
