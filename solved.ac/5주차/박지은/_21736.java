import java.io.*;
import java.util.*;

/**
 * @Description 헌내기는 친구가 필요해
 */

public class _21736 {

    static String map[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1}; // 좌우 체크
    static int dirY[] = {-1, 1, 0, 0}; // 상하 체크
    // now 기준 -> 우, 좌, 상, 하
    static int N, M, dyX, dyY, nowX, nowY;
    static int peopleCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visit = new boolean[N][M];

        // map
        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for (int j=0 ; j < M ; j++) {
                map[i][j] = String.valueOf(str.charAt(j));

                // 도연이 위치 정보 저장
                if (map[i][j].equals("I")) {
                    dyX = i;
                    dyY = j;
                }
            }
        }

        // 도연이 위치부터 친구 찾기
        peopleSearch(dyX, dyY);

        System.out.println(peopleCnt == 0 ? "TT" : peopleCnt);
    }

    static void peopleSearch(int x, int y) {
        visit[x][y] = true;
        if (map[x][y].equals("P")) {
            peopleCnt++;
        }

        for (int i = 0 ; i < 4 ; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            // 맵 범위, 방문 이력 없고, 벽이 아니면
            if(isRangeOk() && !visit[nowX][nowY] && !map[nowX][nowY].equals("X")) {
                visit[nowX][nowY] = true;
                peopleSearch(nowX, nowY);
            }
        }
    }

    static boolean isRangeOk() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < M);
    }
}