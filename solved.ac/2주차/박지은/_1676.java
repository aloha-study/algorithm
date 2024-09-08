import java.io.*;

/**
 * @Description 팩토리얼 0의 개수
 */
public class _1676 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 10(5 * 2) count -> count2 는 count5보다 무조건 많음
        System.out.println(count5(N));
    }

    private static int count5(int N){
        int count = 0;
        for (int i = 1 ; i <= N ; i++){
            int num = i;
            while (num % 5 == 0){
                count++;
                num /= 5;
            }
        }
        return count;
    }
}
