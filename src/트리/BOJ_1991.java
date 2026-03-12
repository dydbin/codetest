package 트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {

    private static int[] left = new int[26];
    private static int[] right = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            left[i] = -1;
            right[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int p = parent -'A';
            if (l != '.') left[p] = l -'A';
            if (r != '.') right[p] = r -'A';
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
    private static void preorder(int node) {
        if (node == -1) return;
        System.out.print((char) (node+'A'));
        preorder(left[node]);
        preorder(right[node]);
    }
    private static void inorder(int node) {
        if (node == -1) return;
        inorder(left[node]);
        System.out.print((char) (node + 'A'));
        inorder(right[node]);
    }

    private static void postorder(int node) {
        if (node == -1) return;
        postorder(left[node]);
        postorder(right[node]);
        System.out.print((char) (node + 'A'));
    }
}
