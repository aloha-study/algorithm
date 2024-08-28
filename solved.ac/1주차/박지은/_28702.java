import java.io.*;

/**
 * @Description FizzBuzz
 */
public class _28702 {
    public static void main(String[] args) throws IOException {

        // 3번의 입력 중 무조건 숫자가 1개 이상 포함
        // 내가 출력할 것? 3번째인 마지막 입력의 다음 값 -> 1입력 +3, 2입력 +2, 3입력 +1
        // 발견한 첫 숫자에 차이를 더하고 조건 판별 -> 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 3; i > 0; i --) {
            String str = br.readLine();
            if (isNumber(str)) {
                int n = Integer.parseInt(str) + i;
                if (n % 3 == 0) {
                    if (n % 5 == 0){
                        System.out.println("FizzBuzz");
                    } else {
                        System.out.println("Fizz");
                    }
                } else {
                    if (n % 5 == 0) {
                        System.out.println("Buzz");
                    } else {
                        System.out.println(n);
                    }
                }
                return;
            }
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("^[0-9]*$");
    }
}