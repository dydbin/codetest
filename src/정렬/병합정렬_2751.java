package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 병합정렬_2751 {
    static int[] A, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1,N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
    static void merge_sort(int start, int end) {
        if (end - start < 1) return;  // 종료조건 : 원소가 1개 이하 -> 이미 정렬

        int mid = start + (end-start) / 2;
        merge_sort(start, mid); //왼쪽
        merge_sort(mid+1, end); //오른쪽
        for (int i = start; i <= end; i++) { //병합 중 원본이 덮어써지는 것을 방지
            tmp[i] = A[i];
        }
        int k = start;      //A 배열에 값을 넣을 위치
        int index1 = start; //왼쪽 배열 시작 포인터
        int index2 = mid+1; //오른쪽 배열 시작 포인터

        // 두 배열 비교 병합
        while (index1 <= mid && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 두 배열 병합 후 남은 index 들을 A배열로 저장
        while (index1 <= mid) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
