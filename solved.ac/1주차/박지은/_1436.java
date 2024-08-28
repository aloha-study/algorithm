import java.io.*;

/**
 * @Description 영화감독 숌
 */
public class _1436 {
    public static void main(String[] args) throws IOException {

        // 666 부터 num++ 증가
        // "666" 문자열 포함 -> cnt++ 증가
        // 입력 받은 N == cnt -> num 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 1;

        while (N != cnt) {
             num++;
             if (String.valueOf(num).contains("666")) {
                 cnt++;
             }
        }

        System.out.println(num);
    }
}