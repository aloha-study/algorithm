import java.io.*;
import java.util.*;

/**
 * @Description 케빈 베이컨의 6단계 법칙
 */

public class _1389 {

    static int INF = 999999999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* 관계도 초기화 -> 0번 인덱스 사용x
            ㄴ 관계 없음 : INF
            ㄴ 관계 있음 : 1
            ㄴ 나 자신 : 0
        * */
        int[][] relation = new int[N + 1][N + 1];
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                relation[i][j] = INF;
                if (i == j) relation[i][j] = 0;
            }
        }
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            relation[p1][p2] = 1;
            relation[p2][p1] = 1;
        }

        // k : 중간 지인 역할
        // 직접 관계가 아닐 경우, 중간 지인(k)와 i,j 의 각 관계를 더해 더 가까운(작은) 단계 찾기
        for(int k = 1 ; k <= N ; k++) {
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    relation[i][j] = Math.min(relation[i][j], relation[i][k]+relation[k][j]);
                }
            }
        }

        // 출력 : 케빈 베이컨 수가 가장 작은 사람
        int minKevinBacon = Integer.MAX_VALUE;
        int minPerson = 0;
        for (int i = 1 ; i <= N ; i++) {
            int sum = 0;
            for (int j = 1 ; j <= N ; j++) {
                sum += relation[i][j];
            }
            if (sum < minKevinBacon) {
                minKevinBacon = sum;
                minPerson = i;
            }
        }
        System.out.println(minPerson);
    }
}