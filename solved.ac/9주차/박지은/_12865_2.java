import java.io.*;
import java.util.*;

/**
 * @Description 평범한 배낭
 * https://www.acmicpc.net/problem/12865
 */
public class _12865_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1 ; i <= N ; i++) { // item
            for (int k = 1 ; k <= K ; k++) { // weight
                dp[i][k] = dp[i-1][k];

                // i번째 물건을 담을 수 있음
                if (weight[i] <= k) {
                    // 1. dp[i - 1][k] : 전 아이템의 dp
                    // 2. value[i] + dp[i - 1][k - weight[i]] : 내 가치 + (현재 총 무게 - 내 무게의 dp)
                    dp[i][k] = Math.max(dp[i - 1][k], value[i] + dp[i - 1][k - weight[i]]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}