import java.io.*;
import java.util.*;

/**
 * @Description 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 */
public class _5052 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 전화번호의 수
            String[] phoneNums = new String[N];

            for (int n = 0 ; n < N ; n++) {
                phoneNums[n] = br.readLine();
            }

            // 일관성 체크
            isConsistency(phoneNums);
        }

        System.out.println(sb.toString());
    }

    public static void isConsistency(String[] arr) {
        // tip) 사전순 정렬
        Arrays.sort(arr);

        // tip) 바로 다음 원소만 비교
        for (int i = 0 ; i < arr.length - 1 ; i ++) {
            if (arr[i + 1].startsWith(arr[i])) {
                sb.append("NO\n");
                return;
            }
        }
        sb.append("YES\n");
    }
}