import java.io.*;
import java.util.*;

/**
 * @Description 덩치
 */
public class _7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] bodys = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            bodys[i][0] = Integer.parseInt(str[0]);	// 몸무게
            bodys[i][1] = Integer.parseInt(str[1]);	// 키
        }

        // 신체 랭크 비교
        StringBuilder bodyRank = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                if (bodys[i][0] < bodys[j][0] && bodys[i][1] < bodys[j][1]) {
                    rank++;
                }
            }
            bodyRank.append(rank).append(" ");
        }
        System.out.println(bodyRank);
    }
}
