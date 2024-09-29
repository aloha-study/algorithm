import java.io.*;
import java.util.*;

/**
 * @Description 퇴사
 */
public class _14501 {

    static int N;
    static List<int[]> schedules = new ArrayList<>();
    static int resultPay;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < N ; i++){
            String[] schedule = br.readLine().split(" ");
            schedules.add(new int[]{Integer.parseInt(schedule[0]), Integer.parseInt(schedule[1])});
        }

        resultPay = 0;
        counsel(0, 0); // 0일 부터 상담 시작

        System.out.println(resultPay);
    }

    static void counsel(int idx, int pay) {
        // 상담 일자가 퇴사 일자를 넘길 경우
        if (idx >= N) {
            resultPay = Math.max(pay, resultPay);
            return;
        }

        int[] schedule = schedules.get(idx);
        // 상담 마무리 가능 여부 체크
        if (idx + schedule[0] <= N) {
            // 상담 종료 일자와 상담비 넣기
            counsel(idx + schedule[0], pay + schedule[1]);
        } else {
            // 상담 종료 일자만 넣기
            counsel(idx + schedule[0], pay);
        }

        // 일자 하루 추가
        counsel(idx + 1, pay);
    }
}
