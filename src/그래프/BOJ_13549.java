package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13549 {
    private static int[] dist;
    private static PriorityQueue<Node> pq;
    private static int N,K;
    private static final int Max = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈 위치 N
        K = Integer.parseInt(st.nextToken()); //동생 위치 K
        dist = new int[Max];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Dijkstra(N);


    }
    private static class Node implements Comparable<Node> {
        int to, weight;
        Node (int end, int weight) {
            this.to = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    private static void Dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int cost = node.weight;
            if (cost > dist[to]) continue;
            if (to == K) {
                System.out.println(cost);
                return;
            }
            int nx = to * 2;
            if (nx < Max && dist[nx] > cost)  {
                dist[nx] = cost;
                pq.offer(new Node(nx, cost));
            }
            if (to-1 >= 0 && dist[to-1] > cost+1) {
                dist[to-1] = cost + 1;
                pq.offer(new Node(to-1, cost+1));
            }
            if (to+1 < Max && dist[to+1] > cost+1) {
                dist[to+1] = cost+1;
                pq.offer(new Node(to+1, cost+1));
            }

        }
    }
    // 0-1 BFS로도 가능
    private static void zeroOneBFS() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            // 1️⃣ 순간이동 (비용 0)
            int next = cur * 2;
            if (next < Max && dist[next] == -1) {
                dist[next] = dist[cur];
                dq.addFirst(next); // 핵심
            }

            // 2️⃣ 뒤로 걷기 (비용 1)
            next = cur - 1;
            if (next >= 0 && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }

            // 3️⃣ 앞으로 걷기 (비용 1)
            next = cur + 1;
            if (next < Max && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }
        }
    }
}
