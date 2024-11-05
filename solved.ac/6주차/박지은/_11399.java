import java.io.*;
import java.util.*;

/**
 * @Description ATM
 */
public class _11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        arr = Arrays.stream(arr).sorted().toArray();

        int sum = 0;
        for (int i = 0 ; i < N ; i++) {
            int time = 0;
            for (int j = 0 ; j < N ; j++) {
                if (i >= j) time += arr[j];
                else break;
            }
            sum += time;
        }
        System.out.println(sum);
    }
}
