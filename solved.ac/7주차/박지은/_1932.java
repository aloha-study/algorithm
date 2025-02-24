import java.io.*;
import java.util.*;

/**
 * @Description 정수 삼각형
 */
public class _1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        // 제일 마지막 줄에 각 최댓값만을 비교
        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}
