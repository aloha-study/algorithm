import java.io.*;

/**
 * @Description 설탕 배달
 */
public class _2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N > 0){
            if (N % 5 == 0){
                count += N / 5;
                N = 0;
            } else{
                count++;
                N -= 3;
            }
        }

        if (N == 0) System.out.println(count);
        else System.out.println(-1);
    }
}
