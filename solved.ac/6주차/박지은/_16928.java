import java.io.*;
import java.util.*;

/**
 * @Description 뱀과 사다리 게임
 */
public class _16928 {

    static int[] board;
    static int[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        // 보드 초기화
        board = new int[101];
        visit = new int[101];
        for (int i = 1 ; i <= 100 ; i++) {
            board[i] = i;
        }

        // 사다리, 뱀 인덱스 세팅
        int total = N + M;
        while (total-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        int result = bfs();
        System.out.println(result);
    }


    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1); // 1부터 시작

        while (true) {
            int nowNum = que.poll();

            // 주사위 1~6
            for (int i = 1 ; i <= 6 ; i++) {
                int nextNum = nowNum + i;

                // 범위 밖이면 무시
                if (nextNum > 100) continue;

                // 방문 이력이 없으면 큐에 추가
                if (visit[board[nextNum]] == 0) {
                    que.offer(board[nextNum]);
                    visit[board[nextNum]] = visit[nowNum] + 1;
                }

                // 100 발견 시 리턴
                if (nextNum == 100) return visit[nextNum];
            }
        }
    }
}
