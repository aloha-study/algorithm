import java.io.*;
import java.util.StringTokenizer;

/**
 * @Description 카잉 달력
 * x가 M 만큼 증가할 때, x값 동일/y값 변화
 * y가 N 만큼 증가할 때, x값 변화/y값 동일
 *
 3(N) * 4(M)
 1:<1,1>    4:<1,4>    7:<1,3>    10:<1,2>
 2:<2,2>    5:<2,1>    8:<2,4>    11:<2,3>
 3:<3,3>    6:<3,2>    9:<3,1>    12:<3,4>
 */

public class _6064 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int limit = lcm(M, N);
            boolean isFind = false;

            for (int i = x ; i <= limit ; i += M) {
                int modY = i % N == 0 ? N : i % N;
                if (modY == y) {
                    System.out.println(i);
                    isFind = true;
                    break;
                }
            }
            if (!isFind) System.out.println("-1");
        }
    }

    // 최소 공배수(LCM)
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대 공약수(GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}