import java.io.*;
import java.util.*;

/**
 * @Description 연구소
 */
public class _14502 {

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int[][] map;
    static int N, M;
    static int maxSafeZone = Integer.MIN_VALUE;
    static Queue<virus> virusQue = new LinkedList<virus>();

    static class virus{
        int x;
        int y;
        public virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        // 0은 빈 칸, 1은 벽, 2는 바이러스
        map = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virusQue.offer(new virus(i, j));
                }
            }
        }

        // 모든 경우의 수 체크 -> dfs
        // 벽 세운 후 바이러스 전파 -> bfs
        dfs(0);

        System.out.println(maxSafeZone);
    }

    public static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (map[i][j] == 0) {
                    // 빈 칸에 벽 세운 후 다음 벽 세우기 -> 3개 모두 완성 되면 벽 철거 후 다음 케이스 탐색
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<virus> que = new LinkedList<>(virusQue);

        // 깊은 복사 : 복사한 배열이 원래 배열을 그대로 가져옴
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!que.isEmpty()){
            virus v = que.poll();

            for(int i=0; i<4; i++) {
                int nowX = v.x + dirX[i];
                int nowY = v.y + dirY[i];

                if (isRangeOk(nowX, nowY) && copyMap[nowX][nowY] == 0) {
                    copyMap[nowX][nowY] = 2;
                    que.add(new virus(nowX, nowY));
                }
            }
        }

        getSafeZone(copyMap);
    }

    static boolean isRangeOk(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    static void getSafeZone(int[][] virusMap) {
        int safeZone = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(virusMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}
