package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퀵정렬_11004 {

    static int[] A;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int M = Integer.parseInt(st.nextToken()); //찾는 인덱스

        A = new int[N+1];
        K = M - 1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) { //0부터 N-1 인덱스
            A[i] = Integer.parseInt(st.nextToken());
        }
        quick(0, N-1);
        System.out.println(A[K]);

    }
    //퀵소트
    static void quick(int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(left, right);

        if(pivotIndex == K) { //K번째 수가 pivot이면 구할 필요 없음.
            return;
        } else if (pivotIndex > K) { // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
            quick(left, pivotIndex -1);
        } else {                      // K가 pivot보다 크면 오른쪽 그룹만 정렬 수행.
            quick(pivotIndex + 1, right);
        }

    }
    //분할
    static int partition(int left, int right) {
        int pivot = A[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (A[j] <= pivot) {
                swap(i, j);
                i++;
            }
        }
        swap(i, right);
        return i;
    }
    static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
