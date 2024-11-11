import java.io.*;
import java.util.*;

/**
 * @Description 테트로미노
 */
public class _14500 {

    static int N, M, answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = { -1, 1, 0, 0 };
    static int[] dirY = { 0, 0, -1, 1 }; // 상 하 좌 우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 완전 탐색
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                visit[i][j] = true;
                findTM(i, j, 1, map[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    // 시작점부터 4개씩 뻗어나가면서 방문 true, step=4 리턴 후 방문 false 처리
    static void findTM(int x, int y, int step, int sum) {
        if (step == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (!isRangeOk(nextX, nextY) || visit[nextX][nextY]) continue;

            // ㅜ 모양 처리(예제3) -> 두번째 칸에서 next가 아닌 원래 x,y 로 findTM
            if (step == 2) {
                visit[nextX][nextY] = true;
                findTM(x, y, step + 1, sum + map[nextX][nextY]);
                visit[nextX][nextY] = false;
            }

            visit[nextX][nextY] = true;
            findTM(nextX, nextY, step + 1, sum + map[nextX][nextY]);
            visit[nextX][nextY] = false;
        }
    }

    static boolean isRangeOk(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
