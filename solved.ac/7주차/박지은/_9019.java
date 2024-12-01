import java.io.*;
import java.util.*;

/**
 * @Description DSLR
 */
public class _9019 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dslr(A, B);
        }
    }

    public static void dslr(int a, int b) {
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        Arrays.fill(command,  ""); // 배열 초기화

        Queue<Integer> que = new LinkedList<>();
        que.add(a);
        visited[a] = true;

        // 큐가 비어있지 않거나, B를 찾지 못했으면 반복
        while (!que.isEmpty() && !visited[b]) {
            int now = que.poll();
            /*
            D : n 두배 후 10000으로 나눈 나머지
            S : 0이면 9999, 아니면 1 빼기
            L : 1234 -> 2341 : 1234를 %1000 (234)에 *10 = 2340, 1234를 /1000 (1) -> 2340 + 1 = 2341
            R : 1234 -> 4123 : 1234를 %10 (4)에 *1000 = 4000, 1234를 /10 (123) -> 4000 + 123 = 4123
            * */
            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                que.add(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }

            if (!visited[S]) {
                que.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }

            if (!visited[L]) {
                que.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }

            if (!visited[R]) {
                que.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
        }
        System.out.println(command[b]);
    }
}
