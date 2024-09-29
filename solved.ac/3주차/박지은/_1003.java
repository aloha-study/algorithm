import java.io.*;
import java.util.*;

/**
 * @Description 피보나치 함수
 */
public class _1003 {

    static int nMax = 40;
    static Integer[][] count = new Integer[nMax + 1][2]; //0, 1 출력 횟수 저장 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        fibonacci();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(count[N][0] + " " + count[N][1]);
        }
    }

    static void fibonacci() {
        // 피보나치 수열 0, 1 초기화
        count[0][0] = 1; // fibo(0) 0의 갯수
        count[0][1] = 0; // fibo(0) 1의 갯수
        count[1][0] = 0; // fibo(1) 0의 갯수
        count[1][1] = 1; // fibo(1) 1의 갯수

        for (int i = 2 ; i <= nMax ; i++){
            count[i][0] = count[i - 1][0] + count[i - 2][0];
            count[i][1] = count[i - 1][1] + count[i - 2][1];
        }
    }
}