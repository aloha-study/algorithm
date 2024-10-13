import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Description 랜선 자르기
 */
public class _1654 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 이미 갖고 있는 랜선의 갯수
        long N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 갯수
        long[] lanLines = new long[K];
        for (int i = 0 ; i < K ; i++){
            lanLines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanLines);
        long low = 1;
        long high = lanLines[K - 1];
        long mid;

        while (low <= high){
            mid = (low +  high) / 2;

            /*
             *  [upper bound 형식]
             *  mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */

            if (calculateLanCnt(mid, lanLines) < N){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        System.out.println(high);
    }

    private static int calculateLanCnt(long lanSize, long[] lanLines) {
        int lanCnt = 0;
        for (long size : lanLines) {
            lanCnt += size / lanSize;
        }
        return lanCnt;
    }
}