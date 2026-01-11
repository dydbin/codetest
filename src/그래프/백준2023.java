package 그래프;

import java.io.*;

/**
 * 소수 찾기. DFS
 */
public class 백준2023 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }
    static void DFS(int number, int length) {
        if (length == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, length + 1);
            }

        }
    }
    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number < 2) return false;

            if (number % i == 0) {
                return false;
            }

        }
        return true;
    }

}
