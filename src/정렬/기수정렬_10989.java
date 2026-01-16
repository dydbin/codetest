package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//기수 정렬 (radix sort)
public class 기수정렬_10989 {
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i =0; i< N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        radix(A,5);

        for (int i = 1; i < N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.println(sb);
    }
    private static void radix(int[] A, int max) {
        int[] output = new int[A.length];
        int jari = 1;
        int count = 0;
        while (count != max) {
            int[] bucket = new int[10];  //0~9까지의 바구니
            //개수 세기 : 끝 자리에 있는 수의 개수
            for (int i =0; i<A.length; i++) {
                bucket[(A[i]/ jari) % 10]++;
            }
            //위치 지정 : 바구니에 담긴 개수를 누적합으로
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            //뒤에서 부터 담기 :
            for (int i = A.length-1; i>=0; i--) {
                output[bucket[(A[i])/jari % 10] -1] = A[i];
                bucket[(A[i] /jari) % 10]--;
            }
            // 해당 자릿수 정렬이 끝난 output 배열을 다시 원래 배열 A에 복사
            for (int i = 0; i< A.length; i++) {
                A[i] = output[i];
            }
            jari = jari * 10;
            count++;
        }
    }
}

/*
값을 비교하지 않는 특이한 정렬
기수 정렬 : 값을 놓고 비교할 자릿수를 정한 다음 해당 자릿수만 비교
시간 복잡도는 O(kn) : k(데이터의 자릿수)
 */