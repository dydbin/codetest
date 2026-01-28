package 그래프;

import java.io.*;
import java.util.*;

public class BOJ_2251 {

    static int[] limit;
    static boolean[][] visited;
    static boolean[] answer = new boolean[201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        visited = new boolean[201][201]; //1~200
        for (int i = 0; i<limit.length; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= limit[2]; i++) {
            if (answer[i]) sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    private static void bfs() {
        Queue<Water> queue = new LinkedList<>();
        // 초기 상태: A=0, B=0, C=limit[2]
        queue.add(new Water(0, 0, limit[2]));
        visited[0][0] = true;
        answer[limit[2]] = true;

        // 6가지 이동 경로 정의 (0:A, 1:B, 2:C)
        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 0, 2, 0, 1};

        while (!queue.isEmpty()) {
            Water curr = queue.poll();

            for (int i = 0; i < 6; i++) {
                int[] next = {curr.a, curr.b, curr.c};

                // 물 옮기기: next[from[i]]에서 next[to[i]]로
                int amount = next[from[i]]; // 옮길 수 있는 최대량
                int space = limit[to[i]] - next[to[i]]; // 받을 곳의 남은 공간

                int move = Math.min(amount, space); // 실제 옮길 양

                next[from[i]] -= move;
                next[to[i]] += move;

                // 이미 확인한 물의 조합(A, B)이 아니라면 큐에 삽입
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Water(next[0], next[1], next[2]));

                    // 조건: 첫 번째 물통(A)이 비어 있을 때
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    // 세 물통의 상태를 저장할 클래스
    static class Water {
        int a, b, c;
        Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
