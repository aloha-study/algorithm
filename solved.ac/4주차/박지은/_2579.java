import java.io.*;

/**
 * @Description 계단 오르기
 */
public class _2579 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] max = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        max[1] = arr[1];
        if (N >= 2) {
            max[2] = arr[1] + arr[2];
        }

        for (int i = 3 ; i <= N ; i++) {
            // 1. 두칸 이동       : 내 인덱스 기준 전전칸(i-2)의 max
            // 2. 두칸 + 한칸 이동 : 내 전(i-1) 계단값 + 전 계단 기준 전전칸(i-3) max
            // 비교 후 큰 값을 현재 계단값(i)과 더하여 저장
            max[i] = Math.max(max[i - 2] , max[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(max[N]);
    }
}
