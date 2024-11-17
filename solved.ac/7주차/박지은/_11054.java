import java.io.*;
import java.util.*;

/**
 * @Description 가장 긴 바이토닉 부분 수열
 */
public class _11054 {

    static int N;
    static int[] arr, r_dp, l_dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        r_dp = new int[N];
        l_dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            rightDP(i);
            leftDP(i);
        }

        // 출력 -> 겹치는 부분 제거하여 max -1
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, r_dp[i] + l_dp[i]);
        }
        System.out.println(max - 1);
    }

    static int rightDP(int idx) {
        // 현재 인덱스 기준 : 진행 방향 오른쪽
        if (r_dp[idx] == 0) {
            r_dp[idx] = 1;

            // 현재 인덱스보다 낮은 인덱스의 값과 비교하여 작은 수가 있다면 dp 증가
            for (int i = idx - 1 ; i >= 0 ; i--) {
                if (arr[i] < arr[idx]) { //
                    r_dp[idx] = Math.max(r_dp[idx], rightDP(i) + 1);
                }
            }
        }
        return r_dp[idx];
    }

    static int leftDP(int idx) {
        // 현재 인덱스 기준 : 진행 방향 왼쪽
        if (l_dp[idx] == 0) {
            l_dp[idx] = 1;

            for (int i = idx + 1 ; i < N ; i++) {
                if (arr[i] < arr[idx]) { //
                    l_dp[idx] = Math.max(l_dp[idx], leftDP(i) + 1);
                }
            }
        }
        return l_dp[idx];
    }
}
