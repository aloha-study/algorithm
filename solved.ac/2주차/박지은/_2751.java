import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description 수 정렬하기 2
 */

// Arrays.sort() 정렬 방식 : DualPivotQuicksort
// -> 평균 : O(nlog(n))
// -> 최악 : O(n^2)

// Collections.sort() 정렬 방식 : TimeSort (삽입 정렬과 합병 정렬을 결합한 정렬)
// -> 평균, 최악 : O(nlog(n))

public class _2751 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0 ; i < N ; i++){
            numList.add(Integer.parseInt(br.readLine()));
        }

        // 1272 ms
        Collections.sort(numList);
        for (int num : numList) {
            sb.append(num).append('\n');
        }

//        // 1384 ms
//        numList.stream()
//                .sorted()
//                .forEach(num -> sb.append(num).append('\n'));

        System.out.println(sb);
    }
}
