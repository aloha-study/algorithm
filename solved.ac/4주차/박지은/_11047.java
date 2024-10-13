import java.io.*;
import java.util.StringTokenizer;

/**
 * @Description 동전 0
 */
public class _11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N개의 종류 동전
        int K = Integer.parseInt(st.nextToken()); // K원
        int[] coins = new int[N];
        for (int i = 0 ; i < N ; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int totalCnt = 0;
        for (int i = N - 1 ; i >= 0 ; i--) {
            if ( K / coins[i] > 0) {
                int coinCnt = K / coins[i];
                totalCnt += coinCnt;
                K = K - (coins[i] * coinCnt);
            }
        }

        System.out.println(totalCnt);
    }
}
