import java.io.*;
import java.util.*;

/**
 * @Description 과일 탕후루
 */
public class _30804 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 탕후루 과일 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tanghuru = new int[N];
        for (int i = 0 ; i < N ; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        // key : 탕후루 종류, value : 탕후루 양
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < N; right++) {
            // 우측 포인터 이동 -> 탕후루 put, 이미 탕후루 존재 시 양 +1
            map.put(tanghuru[right], map.getOrDefault(tanghuru[right], 0) + 1);

            while (map.size() > 2) {
                // 탕후루 종류가 2개 초과 시 왼측 탕후루 양 -1
                map.put(tanghuru[left], map.get(tanghuru[left]) - 1);

                // 탕후루 양이 0 이면 사용 못하는 탕후루 -> map 에서 제거
                if (map.get(tanghuru[left]) == 0) {
                    map.remove(tanghuru[left]);
                }

                // 왼측 포인터 이동
                left++;
            }
            // 우측, 왼측 포인터 사이의 길이 구하여 maxLength 비교
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }
}
