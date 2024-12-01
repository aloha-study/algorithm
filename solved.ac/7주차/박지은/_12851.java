import java.io.*;
import java.util.*;

/**
 * @Description 숨바꼭질 2
 */
public class _12851 {

    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        bfs(N);
        System.out.println(min + "\n" + count);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            // 현재 좌표의 시간이 min 보다 크면 비교할 필요 x
            if (time[now] > min) continue;

            int[] dir = {now - 1, now + 1, now * 2};
            for (int i = 0 ; i < 3 ; i++) {
                int next = dir[i];

                // 범위 check
                if (next < 0 || next > 100000) continue;

                // 목표 도착
                if (next == K) {
                    min = time[now];
                    count++;
                }

                // 처음 next 거나, next 가 now 바로 다음일 경우(+1초) add
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}