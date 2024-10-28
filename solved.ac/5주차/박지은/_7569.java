import java.io.*;
import java.util.*;

/**
 * @Description 토마토
 */

public class _7569 {

    static int M, N, H; // 가로, 세로, 높이

    static int box[][][];
    static int nowCol, nowRow, nowHeight;

    // 상, 하, 좌, 우, 아래층, 위층
    static int dirX[] = {0, 0, -1, 1, 0, 0};
    static int dirY[] = {-1, 1, 0, 0, 0 ,0};
    static int dirZ[] = {0, 0, 0, 0, -1, 1};

    static Queue<Point> que = new LinkedList<>();

    static class Point {
        int col, row, height;

        Point(int col, int row, int height) {
            this.col = col;
            this.row = row;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];
        for (int h = 0 ; h < H ; h++) {
            for (int n = 0 ; n < N ; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0 ; m < M ; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());

                    // 익은 토마토 큐에 저장
                    if (box[h][n][m] == 1) {
                        que.add(new Point(m, n, h)); // 가로, 세로, 높이
                    }
                }
            }
        }

        bfs();
        System.out.println(getMaxDay());
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Point p = que.poll();

            int col = p.col, row = p.row, height = p.height;
            for (int dir = 0; dir < 6; dir++) {
                nowCol = col + dirX[dir];
                nowRow = row + dirY[dir];
                nowHeight = height + dirZ[dir];

                // 범위 체크, 익지 않은 토마토인지 체크
                if (isRangeOk() && isNotRipe()) {
                    // 큐에 저장하여, 전 토마토 익은 날짜에서 +1
                    que.add(new Point(nowCol, nowRow, nowHeight));
                    box[nowHeight][nowRow][nowCol] = box[height][row][col] + 1;
                }
            }
        }
    }

    static boolean isRangeOk() {
        return (nowCol >= 0 && nowCol < M && nowRow >= 0 && nowRow < N && nowHeight >= 0 && nowHeight < H);
    }

    static boolean isNotRipe() {
        return (box[nowHeight][nowRow][nowCol] == 0);
    }

    static int getMaxDay(){
        int maxDay = Integer.MIN_VALUE;
        for (int h = 0 ; h < H ; h++) {
            for (int n = 0 ; n < N ; n++) {
                for (int m = 0 ; m < M ; m++) {
                    if (box[h][n][m] == 0) {
                        return -1;
                    }
                    maxDay = Math.max(maxDay, box[h][n][m]);
                }
            }
        }
        // 최댓값이 1이면 원래 모두 익었던 것, 익은 토마토 1부터 시작했으니 실 소요일은 -1
        return maxDay == 1 ? 0 : (maxDay - 1);
    }
}