import java.io.*;
import java.util.*;

/**
 * @Description N-Queen
 * https://www.acmicpc.net/problem/9663
 */
public class _9663 {

    static int N;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        // 모든 탐색이 끝나면 count 증가
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            arr[depth] = i;

            // 놓을 수 있는 위치라면 재귀
            if (canPlaceQueen(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean canPlaceQueen(int point) {
        for (int i = 0 ; i < point ; i++) {

            // 같은 행에 위치할 경우
            if (arr[point] == arr[i]) return false;

                // 대각선상에 위치할 경우 -> 각 열의 차 == 각 행의 차
            else if (Math.abs(point - i) == Math.abs(arr[point] - arr[i])) return false;
        }
        return true;
    }
}
