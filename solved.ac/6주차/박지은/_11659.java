import java.io.*;
import java.util.*;

/**
 * @Description 구간 합 구하기 4
 */
public class _11659 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 누적합 구하기
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max += num;
            arr[i] = max;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(arr[end] - arr[start - 1]);
        }
    }
}
