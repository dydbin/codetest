package 자료구조;

import java.io.*;
import java.util.*;

public class stack_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }
        for (int i = 0; i<N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }
}
