import java.io.*;

/**
 * @Description 잃어버린 괄호
 */

public class _1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;	// 초기 상태
        String[] minus = br.readLine().split("-");

        for (int i = 0 ; i < minus.length ; i++) {
            int tempSum = 0;

            // 뺄셈 분리
            String[] plus = minus[i].split("\\+");

            // 덧셈 분리 후 더하기
            for (int j = 0 ; j < plus.length ; j++) {
                tempSum += Integer.parseInt(plus[j]);
            }

            // 첫 번째 토큰인 경우 tempSum -> 첫 수
            if (sum == Integer.MAX_VALUE) {
                sum = tempSum;
            } else {
                sum -= tempSum;
            }
        }
        System.out.println(sum);
    }
}