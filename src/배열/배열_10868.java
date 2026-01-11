package 배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 최솟값 문제 => 세그먼트 트리
public class 배열_10868 {
    static int N,M;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //세그먼트 트리 크기 : 완전 이진트리 형태 => 최대 노드 수는 4N보다 작음
        tree = new int[4*N];

        // 트리 생성  node = 1 -> 루트 , 구간 [1,N]
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(1, 1, N, a, b)).append('\n');
        }

        System.out.print(sb);

    }
    static void build(int node, int start, int end) {
        if(start==end) { //리프노드라면, tree의 노드값 = 배열의 시작값.
            tree[node] = arr[start];
            return;
        }
        int mid = (start+end) / 2;  // int mid = (start + end) >> 1; // 나누기 2와 동일
        build(node*2, start,mid);
        build(node * 2+1, mid+1, end);

        tree[node] = Math.min(tree[node*2], tree[node*2+1]); //자식중 작은값을 트리의 노드값으로.
    }

    // 구간 최소값 쿼리
    static int query(int node, int start, int end, int left, int right) {
        // 범위 밖
        if (right < start || end < left) {
            return Integer.MAX_VALUE;   //최솟값에 영향 안주도록 최대값 반환
        }

        // 완전히 포함
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int l = query(node * 2, start, mid, left, right);
        int r = query(node * 2 + 1, mid + 1, end, left, right);

        return Math.min(l, r);
    }
}
/*
1부터 100,000개의 정수 중 a번째 정수와 b번째 정수 -> 최솟값 찾기
a,b 쌍이 M개  a = 1이고 b=4면 1부터 4중 최솟값
 */