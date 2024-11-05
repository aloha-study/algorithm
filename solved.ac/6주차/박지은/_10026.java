import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 적록색약
 */
public class _10026 {

    static char[][] map;
    static boolean[][] visit;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int N, nowX, nowY;
    static int areaColorStrong = 0, areaColorWeak = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 적록색약이 아닌 사람이 보는 영역 구하기
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (!visit[i][j]) {
                    bfsColorStrong(i, j);
                    areaColorStrong++;
                }
            }
        }

        // 방문 배열 초기화
        visit = new boolean[N][N];

        // 적록색약인 사람이 보는 영역 구하기
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (!visit[i][j]) {
                    bfsColorWeak(i, j);
                    areaColorWeak++;
                }
            }
        }

        System.out.println(areaColorStrong + " " + areaColorWeak);
    }

    static void bfsColorStrong(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        char nowColor = map[x][y];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                nowX = now[0] + dirX[i];
                nowY = now[1] + dirY[i];

                if (isRangeOk() && !visit[nowX][nowY] && map[nowX][nowY] == nowColor) {
                    visit[nowX][nowY] = true;
                    queue.add(new int[]{nowX, nowY});
                }
            }
        }
    }

    static void bfsColorWeak(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        char nowColor = map[x][y];
        boolean isColorWeak = (nowColor == 'R' || nowColor == 'G');

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                nowX = now[0] + dirX[i];
                nowY = now[1] + dirY[i];

                if (isRangeOk() && !visit[nowX][nowY]) {
                    char nextColor = map[nowX][nowY];

                    if ((isColorWeak && (nextColor == 'R' || nextColor == 'G'))
                            || (!isColorWeak && nextColor == nowColor)) {
                        visit[nowX][nowY] = true;
                        queue.add(new int[]{nowX, nowY});
                    }
                }
            }
        }
    }

    static boolean isRangeOk() {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    }
}
