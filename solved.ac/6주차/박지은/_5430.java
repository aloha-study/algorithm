import java.io.*;
import java.util.*;

/**
 * @Description AC
 * 시간 초과로 덱을 활용하여 문제 풀이
 */
public class _5430 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 입력
            String p = br.readLine();                   // 수행 함수
            int n = Integer.parseInt(br.readLine());    // 입력 받을 정수의 수
            String s = br.readLine();                   // 정수 배열

            // 함수 호출
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(s, "[],");
            for (int i = 0 ; i < n ; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(p, deque);
        }

        // 출력
        System.out.println(sb);
    }

    static void AC(String command, Deque<Integer> deque) {
        boolean isReverse = false;

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isReverse = !isReverse;
            } else {
                if (isReverse) {
                    // 뒤에서 탈락
                    if (deque.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                } else {
                    // 앞에서 탈락
                    if (deque.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        // 출력 만들기
        sb.append("[");
        if (!deque.isEmpty()) {
            if (isReverse) {
                // 뒤부터 출력
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            } else {
                // 앞부터 출력
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
        }
        sb.append("]\n");
    }
}
