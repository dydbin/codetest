package 트리;

import java.util.*;
import java.io.*;

public class BOJ_1068 {

    private static List<Integer>[] tree;
    private static int root = 0;
    private static int answer = 0;
    private static int delNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                tree[parent].add(i);
            } else {
                root = i;
            }

        }
        delNode = Integer.parseInt(br.readLine());

        if (delNode == root) {
            System.out.println(0);
        } else {
            Dfs(root);
            System.out.println(answer);
        }

    }
    private static void Dfs(int number) {
        int childCount = 0;

        for (int child : tree[number]) {
            if (child == delNode) continue;
            childCount++;
            Dfs(child);
        }

        if (childCount == 0) {
            answer++;
        }
    }
}
