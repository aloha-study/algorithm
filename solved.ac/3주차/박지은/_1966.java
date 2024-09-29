import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 프린터 큐
 */
public class _1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TestCase = Integer.parseInt(br.readLine());

        while (TestCase != 0){
            String[] docsInfo = br.readLine().split(" ");
            String[] docsKeys = br.readLine().split(" ");

            int N = Integer.parseInt(docsInfo[0]); // 문서의 개수
            int M = Integer.parseInt(docsInfo[1]); // 출력 순서를 구할 문서의 인덱스

            Queue<int[]> queue = new LinkedList<>(); // 문서 중요도 큐
            for (int i = 0; i < N ; i++){
                // 문서의 인덱스와 값을 배열로 큐에 저장
                queue.add(new int[] {i, Integer.parseInt(docsKeys[i])});
            }

            int docsSeq = calculateDocsSeq(M, queue);
            sb.append(docsSeq).append('\n');

            TestCase--;
        }
        System.out.println(sb);
    }

    private static int calculateDocsSeq(int docsIdx, Queue<int[]> docsQue) {
        int printCnt = 0;
        while (true){
            int[] current = docsQue.poll();
            boolean isMax = true;

            // 현재 맨앞 큐의 중요도가 제일 큰 값인지 체크
            for (int[] que : docsQue){
                if (que[1] > current[1]){
                    isMax = false;
                    break;
                }
            }

            // 중요도가 가장 큰 값이면 출력 += 1 아니라면 큐 맨 뒤로 보내기
            if (isMax){
                printCnt++;
                if (current[0] == docsIdx) break;
            } else{
                docsQue.add(current);
            }
        }
        return printCnt;
    }
}
