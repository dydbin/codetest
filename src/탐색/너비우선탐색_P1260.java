package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 너비우선탐색_P1260 {
    public static void main(String[] args) throws Exception {
        int N,M,V;
        int[] visted;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken()); //노드
        M =  Integer.parseInt(st.nextToken()); //에지
        V =  Integer.parseInt(st.nextToken()); //시작점
        visted = new int[N+1];

    }
}
