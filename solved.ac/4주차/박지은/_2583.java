import java.io.*;
import java.util.*;

/**
 * @Description 영역 구하기
 */
public class _2583 {

    static int M, N;
    static int[][] map;
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1}; // 좌우 체크
    static int dirY[] = {-1, 1, 0, 0}; // 상하 체크
    // now 기준 -> 우, 좌, 상, 하

    static int area = 0, areaNum = 0;
    static int nowX, nowY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        map = new int[M][N];
        visit = new boolean[M][N];
        int K = Integer.parseInt(st.nextToken()); // 사각형 갯수

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            // 사각형이 있는 영역 : 999, 없는 영역 : 0 그리기
            draw(leftX, leftY, rightX, rightY);
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0 ; i < M ; i++) {
            for (int j = 0; j < N ; j ++) {

                // 영역의 첫 구역 시작
                if(visit[i][j] == false && map[i][j] == 0) {
                    area = 0;
                    areaNum++;
                    searchArea(i, j);
                    areas.add(area);
                }
            }
        }

        // 출력
        Collections.sort(areas);
        System.out.println(areaNum);
        areas.stream().forEach(i -> System.out.print(i + " "));
    }

    static void draw(int leftX, int leftY, int rightX, int rightY) {
        int garo = rightX - leftX;
        int sero = rightY - leftY;

        // 시작 좌표(leftX, rightY) -> 시작 좌표에 맞춰 배열 인덱스 값을 구하기
        int startI = M - rightY;    // y좌표 : map 행(M)과 반전
        int startJ = leftX;         // x좌표 : map 열(N) 그대로

        for (int i = startI ; i < startI + sero ; i++) {
            for (int j = startJ ; j < startJ + garo ; j++) {
                if (map[i][j] == 0) map[i][j] = 999;
            }
        }
    }

    static void searchArea(int x, int y) {
        visit[x][y] = true;
        map[x][y] = areaNum;
        area++;

        for (int i = 0 ; i < 4 ; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            // 맵 범위, 방문 이력 없고, 1인지 체크
            if(isRangeOk() && visit[nowX][nowY] == false && map[nowX][nowY] == 0) {
                visit[nowX][nowY] = true;
                map[nowX][nowY] = areaNum;

                searchArea(nowX, nowY);
            }
        }
    }

    static boolean isRangeOk() {
        return (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N);
    }
}
