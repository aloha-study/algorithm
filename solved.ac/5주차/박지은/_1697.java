import java.io.*;
import java.util.*;

/**
 * @Description 숨바꼭질
 * BFS(너비 우선 탐색, Breadth-First Search)
 */

public class _1697 {

    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int minTime = findPerson(N);
        System.out.println(minTime);
    }

    private static int findPerson(int start) {
        // start 이동 가능 위치 : -1, +1, *2
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int idx = start;
        visit[idx] = 1;
        while (!queue.isEmpty()) {
            int k = queue.poll();

            // 찾으면 해당 이동 시간 -1 리턴 -> 초기화 1로 진행
            if (k == K) {
                return visit[k] - 1;
            }
            // -1 이동
            if (k - 1 >= 0 && visit[k - 1] == 0) {
                visit[k - 1] = visit[k] + 1;
                queue.add(k - 1);
            }
            // +1 이동
            if (k + 1 < visit.length && visit[k + 1] == 0) {
                visit[k + 1] = visit[k] + 1;
                queue.add(k + 1);
            }
            // *2 이동
            if (k * 2 < visit.length && visit[k * 2] == 0) {
                visit[k * 2] = visit[k] + 1;
                queue.add(k * 2);
            }
        }
        return -1;
    }
}