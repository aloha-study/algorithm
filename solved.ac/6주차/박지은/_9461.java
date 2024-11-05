import java.io.*;

/**
 * @Description 파도반 수열
 */
public class _9461 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        for (int n = 5 ; n <= 100 ; n++) {
            arr[n] = arr[n - 1] + arr[n - 5];
        }

        for (int i = 0 ; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(arr[N]);
        }
    }
}
