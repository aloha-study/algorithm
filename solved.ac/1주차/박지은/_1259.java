import java.io.*;

/**
 * @Description 팰린드롬수
 */
public class _1259 {
    public static void main(String[] args) throws IOException {

        // 0 이면 입력 끝
        // 입력 받은 숫자를 뒤집어서 저장
        // 비교 후 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String num = br.readLine();
            if (Integer.parseInt(num) == 0) break;

            String reverseNum = "";
            for (int i = num.length()-1; i >= 0; i--){
                reverseNum += num.charAt(i);
            }

            if (num.equals(reverseNum)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
