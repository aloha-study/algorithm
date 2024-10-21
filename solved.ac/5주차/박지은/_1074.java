import java.io.*;
import java.util.StringTokenizer;

/**
 * @Description Z
 */

public class _1074 {
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 한 변의 사이즈
        int size = (int) Math.pow(2, N);

        // 4개로 나눠 각 구역 찾기
        findZone(size, r, c);

        // 출력
        System.out.println(count);
    }

    static void findZone(int size, int r, int c){
        if (size == 1) return;

        int half = size / 2;
        int num;

        if (r < half && c < half) {
            // 1구역 -> r,c 좌표 그대로
            num = 0;
        } else if (r < half && c >= half) {
            // 2구역 -> r좌표 그대로, c좌표 변경
            num = 1;
            c = c - half;
        } else if (r >= half && c < half) {
            // 3구역 -> r좌표 변경, c좌표 그대로
            num = 2;
            r = r - half;
        } else {
            // 4구역 -> r,c 좌표 변경
            num = 3;
            r = r - half;
            c = c - half;
        }

        count += (size * size / 4) * num;
        findZone(half, r, c);
    }
}