import java.io.*;
import java.util.*;

/**
 * @Description 듣보잡
 */
public class _1764 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // TreeSet -> 중복 저장x, 순서 보장x
        // HashSet 과 달리 이진 탐색 트리(BinarySearchTree)구조 -> 추가/삭제 오래 걸림, 정렬/검색 빠름
        Set<String> noListenPeople = new TreeSet<>();
        Set<String> noSeePeople = new TreeSet<>();

        for (int i = 0 ; i < N ; i++) {
            noListenPeople.add(br.readLine());
        }

        for (int i = 0 ; i < M ; i++) {
            noSeePeople.add(br.readLine());
        }

        // 교집합 구하기
        noListenPeople.retainAll(noSeePeople);

        // 출력
        sb.append(noListenPeople.size()).append("\n");
        for (String s : noListenPeople) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
