import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Description 경로 찾기
 */

public class _11403 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 중간 경로(k)을 통해 갈 수 있는 길이 있는지 체크
        for (int k = 0 ; k < N ; k++) {
            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        // 출력
        Arrays.stream(map)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(e -> System.out.print(e + " "));
                    System.out.println();
                });
    }
}