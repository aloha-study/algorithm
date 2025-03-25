import java.io.*;
import java.util.*;

/**
 * @Description 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */
public class _15686 {

    static class Juso {
        int x;
        int y;

        Juso(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static ArrayList<Juso> house;
    static ArrayList<Juso> chicken;
    static boolean[] open;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N줄의 도시 정보
        M = Integer.parseInt(st.nextToken());   // 수익을 많이 낼 수 있는 치킨집 수
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] ==  1) house.add(new Juso(i, j));
                else if (map[i][j] == 2) chicken.add(new Juso(i, j));
            }
        }
        open = new boolean[chicken.size()];

        // 깊이 우선 탐색
        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int start, int cnt) {
        // 치킨집 오픈수와 일치하는지 체크, 최소 거리 구하기
        if (cnt == M) {
            int nowResult = 0;

            for (int i = 0 ; i < house.size() ; i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0 ; j < chicken.size() ; j++) {
                    if (open[j]) {
                        // (r1, c1)과 (r2, c2) 사이의 거리 = |r1-r2| + |c1-c2|
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                nowResult +=  temp;
            }
            result = Math.min(result, nowResult);
        }

        // 백트래킹
        for (int i = start ; i < chicken.size() ; i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}