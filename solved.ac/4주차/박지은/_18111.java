import java.io.*;
import java.util.*;

/**
 * @Description 마인크래프트
 */
public class _18111 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 블럭

        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) min = map[i][j];
                if (max < map[i][j]) max = map[i][j];
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        // map 최소 높이부터 최대 높이까지 반복
        for (int h = min ; h <= max ; h++) {
            int workTime = 0;
            int block = B;

            // i,j 좌표
            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < M ; j++) {
                    if (map[i][j] > h) {
                        // 1번 작업 -> 높아서 제거
                        workTime += (map[i][j] - h) * 2;
                        block += map[i][j] - h;
                    } else {
                        // 2번 작업 -> 낮아서 추가
                        workTime += h - map[i][j];
                        block -= h - map[i][j];
                    }
                }
            }

            // 블럭 다쓰면 종료
            if (block < 0) break;

            // 현재 작업 시간이 저장된 최소 시간보다 작으면 변경
            if (workTime <= minTime) {
                minTime = workTime;
                height = h;
            }
        }

        System.out.println(minTime + " " + height);
    }
}
