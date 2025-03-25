import java.io.*;
import java.util.*;

/**
 * @Description 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 */
public class _2206 {

    static int N, M, nowX, nowY;
    static int[][] map;
    static boolean[][][] visit;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1}; // 상하좌우

    static class Location {
        int x;
        int y;
        int distance;
        boolean breaked;

        public Location(int x, int y, int distance, boolean breaked) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.breaked = breaked;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1][2];

        for (int i = 1 ; i <= N ; i++) {
            String str = br.readLine();
            for (int j = 1 ; j <= M ; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(new Location(1, 1, 1, false));
    }

    public static void bfs(Location loc) {
        /*
        3차원 배열 == map 2개
            -> 0번 map 부수지 않고 탐색, 1번 map 부수고 탐색

        1. 벽이 아니면
            1-1. 부순 벽이 없으면 -> visit[x][y][0] 방문 처리, add queue
            1-2. 부순 벽이 있으면 -> visit[x][y][1] 방문 처리, add queue
        2. 벽이면
            2-1. 부순 벽이 없으면 -> 부수고, visit[x][y][1] 방문 처리, add queue
            2-2. 부순 벽이 있으면 -> 또 부술수 없기에 pass
        */

        Queue<Location> que = new LinkedList<>();
        que.add(loc);

        while (!que.isEmpty()) {
            Location nowLoc = que.poll();

            // 목적지 도착 시 거리 출력
            if (nowLoc.x == N && nowLoc.y == M) {
                System.out.println(nowLoc.distance);
                return;
            }

            // 상하좌우 탐색
            for (int d = 0 ; d < 4 ; d++) {
                nowX = nowLoc.x + dirX[d];
                nowY = nowLoc.y + dirY[d];

                // 범위 체크
                if (!isRangeOk()) continue;

                // 1. 벽이 아니면
                if (map[nowX][nowY] == 0) {
                    // 1-1. 부순 벽이 없으면 -> visit[x][y][0] 방문 처리, add queue
                    if (!nowLoc.breaked && !visit[nowX][nowY][0]) {
                        visit[nowX][nowY][0] = true;
                        que.add(new Location(nowX, nowY, nowLoc.distance + 1, false));
                    }
                    // 1-2. 부순 벽이 있으면 -> visit[x][y][1] 방문 처리, add queue
                    else if (nowLoc.breaked && !visit[nowX][nowY][1]) {
                        visit[nowX][nowY][1] = true;
                        que.add(new Location(nowX, nowY, nowLoc.distance + 1, true));
                    }
                }
                // 2. 벽이면
                else if (map[nowX][nowY] == 1) {
                    // 2-1. 부순 벽이 없으면 -> 부수고, visit[x][y][1] 방문 처리, add queue
                    if (!nowLoc.breaked) {
                        visit[nowX][nowY][1] = true;
                        que.add(new Location(nowX, nowY, nowLoc.distance + 1, true));
                    }
                    // 2-2. 부순 벽이 있으면 -> 또 부술수 없기에 pass
                }
            }
        }

        // 도착지에 못오면 -1 출력
        System.out.println(-1);
    }

    static boolean isRangeOk() {
        return (nowX >= 1 && nowX <= N && nowY >= 1 && nowY <= M);
    }
}