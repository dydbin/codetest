package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 버블정렬_1377 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Element[] A = new Element[N];

        for (int i = 0; i <N; i++) {
            A[i] = new Element(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index -i;
            }
        }
        System.out.println(max+1);
    }
    static class Element implements Comparable<Element> {
        int value;
        int index;
        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Element o) {
            return this.value - o.value;
        }
    }
}
