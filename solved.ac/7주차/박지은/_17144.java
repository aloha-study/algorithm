import java.io.*;
import java.util.*;

/**
 * @Description 미세먼지 안녕!
 */
public class _17144 {

    static int R, C, T;
    static int[][] map, tempMap;
    public static int[] cleanerU = new int[2];
    public static int[] cleanerD = new int[2];
    public static Queue<Air> dirty = new LinkedList<>();
    public static int[] dirX = {-1, 1, 0, 0};
    public static int[] dirY = {0, 0, -1, 1}; // 상하좌우

    public static class Air {
        int x;
        int y;
        int size;

        public Air() {}
        public Air(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 맵 세팅
        boolean isFind = false;
        for(int i = 0 ; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                // 공기 청정기 찾기
                if(map[i][j] == -1 && !isFind) {
                    cleanerU[0] = i;
                    cleanerD[0] = i + 1;
                    isFind = true;
                }
                // 먼지 찾기
                else if(map[i][j] > 0) {
                    dirty.add(new Air(i, j, map[i][j]));
                }
            }
        }

//

        while (T-- > 0) {
            // 기존 먼지 복사
            Queue<Air> que = new LinkedList<>(dirty);
            dirty.clear();

            int[][] visited = new int[R][C];
            tempMap = new int[R][C];

            // 먼지 확산 후 tempMap 에 저장
            while (!que.isEmpty()) {
                Air cur = que.poll();

                if(visited[cur.x][cur.y] > 0) continue;

                int count = 0;
                int spread = (int) Math.floor(cur.size / 5);
                for (int i = 0 ; i < 4 ; i++) {
                    int nowX = cur.x + dirX[i];
                    int nowY = cur.y + dirY[i];

                    // 범위 오류거나 공기 청정기라면 pass
                    if (!isRangeOk(nowX, nowY) || map[nowX][nowY] == -1) continue;

                    // 먼지 확산과, 확산 카운트 증가
                    count++;
                    tempMap[nowX][nowY] += spread;
                }
                // 내 위치에서 확산해버린 먼지 빼기
                tempMap[cur.x][cur.y] -= spread * count;
            }

            // tempMap 결과 값 map 에 적용
            for (int i = 0 ; i < R ; i++) {
                for(int j = 0 ; j < C ; j++) {
                    map[i][j] += tempMap[i][j];
                }
            }

            // 공기 청정기 가동
            cleaningTopAir();
            cleaningBottomAir();

            // 그 다음 먼지들 큐에 저장
            for(int i = 0 ; i < R ; i++) {
                for(int j = 0 ; j < C ; j++) {
                    if(map[i][j] > 0) dirty.add(new Air(i, j, map[i][j]));
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if (map[i][j] > 0) { // 공기 청정기 제외
                    answer += map[i][j];
                }
            }
        }

        System.out.print(answer);
    }

    // 공기 청정기 위쪽 -> 반시계
    public static void cleaningTopAir() {
        // ⬇️
        for (int i = cleanerU[0] - 1 ; i > 0 ; i--) {
            map[i][0] = map[i - 1][0];
        }
        // ⬅️
        for (int i = 0 ; i < C - 1 ; i++) {
            map[0][i] = map[0][i + 1];
        }
        // ⬆️
        for (int i = 0 ; i < cleanerU[0] ; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        // ➡️
        for (int i = C - 1 ; i > 1 ; i--) {
            map[cleanerU[0]][i] = map[cleanerU[0]][i - 1];
        }
        // 시작 위치 0 초기화
        map[cleanerU[0]][1] = 0;
    }

    // 공기 청정기 아래쪽 -> 시계
    public static void cleaningBottomAir() {
        // ⬆️
        for (int i = cleanerD[0] + 1 ; i < R - 1 ; i++) {
            map[i][0] = map[i + 1][0];
        }
        // ⬅️
        for (int i = 0 ; i < C - 1 ; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        // ⬇️
        for (int i = R - 1 ; i > cleanerD[0] ; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        // ➡️
        for (int i = C - 1 ; i > 1 ; i--) {
            map[cleanerD[0]][i] = map[cleanerD[0]][i - 1];
        }
        // 시작 위치 0 초기화
        map[cleanerD[0]][1] = 0;
    }

    static boolean isRangeOk(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
