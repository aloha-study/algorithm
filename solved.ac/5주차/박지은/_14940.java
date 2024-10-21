import java.io.*;
import java.util.*;

/**
 * @Description 쉬운 최단거리
 */

public class _14940 {

    static int[][] map;
    static int[][] distance;
    static boolean[][] visit;
    static int dirX[] = {-1, 1, 0, 0}; // now 기준 -> 상, 하, 좌, 우
    static int dirY[] = {0, 0, -1, 1};
    static int N, M, nowX, nowY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];
        visit = new boolean[N][M];

        int startX = 0, startY = 0;
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 0 갈수 없는 땅, 1 갈수 있는 땅, 2 목표 지점
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        bfs(startX, startY);

        // 갈수 없는 땅 -1 처리 후 출력
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (!visit[i][j]) distance[i][j] = -1;
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                nowX = now[0] + dirX[i];
                nowY = now[1] + dirY[i];

                if (isRangeOk() && !visit[nowX][nowY] && map[nowX][nowY] == 1) {
                    visit[nowX][nowY] = true;
                    distance[nowX][nowY] = distance[now[0]][now[1]] + 1;
                    queue.add(new int[]{nowX, nowY});
                }
            }
        }
    }

    static boolean isRangeOk() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < M);
    }
}