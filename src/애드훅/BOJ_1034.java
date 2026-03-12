package 애드훅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1034 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] rows = new String[N];
        for (int i = 0; i < N; i++) {
            rows[i] = br.readLine().trim();
        }

        int K = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (String r : rows) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        int answer = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue();

            int z = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '0') {
                    z++;
                }
            }
            if (z <= K && ((K-z) % 2 == 0)) {
                answer = Math.max(answer, count);
            }
        }
        System.out.println(answer);
    }
}
