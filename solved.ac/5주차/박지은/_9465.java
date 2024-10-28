import java.io.*;
import java.util.*;

/**
 * @Description 스티커
 * bfs 가 아니라 dp 로 풀어야하나,..보다ㅠ
 */

public class _9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            // 입력
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];

            for (int i = 0 ; i < 2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < n ; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 구현
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            if (n >= 2) {
               dp[0][1] = dp[1][0] + sticker[0][1];
               dp[1][1] = dp[0][0] + sticker[1][1];
            }

            for (int i = 2 ; i < n ; i++) {
                // 내 위치에서 스티커를 뗀다면 -> 자신의 왼쪽 대각선 값 / 자신의 왼쪽 대각선의 왼쪽 값
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}