import java.io.*;
import java.util.*;

/**
 * @Description 평범한 배낭
 */
public class _12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N + 1][2]; // Weight, Value

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // Weight
            items[i][1] = Integer.parseInt(st.nextToken()); // Value
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int k = 1; k <= K; k++) { // weight
            for (int i = 1; i <= N; i++) { // item
                dp[i][k] = dp[i - 1][k];
                if (k - items[i][0] >= 0) {
                    // dp 에는 최대 가치만을 저장
                    // 1. dp[i - 1][k] : 전 아이템의 dp
                    // 2. items[i][1] + dp[i - 1][k - items[i][0]] : 내 가치 + (현재 총 무게 - 내 무게 = 나머지 무게의 dp)
                    dp[i][k] = Math.max(dp[i - 1][k], items[i][1] + dp[i - 1][k - items[i][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
