import java.util.*;
import java.io.*;

/**
 * @Description 단지번호붙이기
 */

public class _2667 {

    static int map[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1}; // 좌우 체크
    static int dirY[] = {-1, 1, 0, 0}; // 상하 체크
    // now 기준 -> 우, 좌, 상, 하


    static int houseCnt = 0, dangiNum = 0;
    static int nowX, nowY, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> dangiList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i=0 ; i < N ; i++) {
            String str = br.readLine();

            for (int j=0 ; j < N ; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N ; j ++) {

                // 단지의 첫 집 시작
                if(visit[i][j] == false && map[i][j] == 1) {
                    houseCnt = 0;
                    dangiNum++;
                    houseSearch(i, j);
                    dangiList.add(houseCnt);
                }

            }
        }

        // 출력
        Collections.sort(dangiList);
        System.out.println(dangiNum);
        for(int cnt : dangiList) {
            System.out.println(cnt);
        }
    }

    static void houseSearch(int x, int y) {
        visit[x][y] = true;
        map[x][y] = dangiNum;
        houseCnt++;

        for (int i = 0 ; i < 4 ; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            // 맵 범위, 방문 이력 없고, 1인지 체크
            if(isRangeOk() && visit[nowX][nowY] == false && map[nowX][nowY] == 1) {
                visit[nowX][nowY] = true;
                map[nowX][nowY] = dangiNum;

                houseSearch(nowX, nowY);
            }
        }

    }

    static boolean isRangeOk() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    }
}