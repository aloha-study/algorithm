import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 바이러스
 */
public class _2606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int total = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        List<List<String>> pairs = new ArrayList<>();
        for (int i = 0 ; i < line ; i++){
            List<String> pair = new ArrayList<>(List.of(br.readLine().split(" ")));
            pairs.add(pair);
        }

        // logic
        List<List<String>> trees = new ArrayList<>();
        int treeCount = 0;
        while (true){
            List<String> tree = new ArrayList<>();

            if (treeCount == 0) {
                for (int i = 0; i < line ; i++) {
                    List<String> pair = pairs.get(i);
                    if (isContain(pair, "1")) tree.addAll(pair);
                }
                trees.add(removeOne(tree));
                if (trees.get(trees.size()-1).size() == 0) break;
                treeCount++;
            } else {
                if (treeCount > 1 && trees.get(trees.size() - 1).equals(trees.get(trees.size() - 2))) break;

                List<String> lastTree = trees.get(trees.size() - 1);
                for (int i = 0; i < line ; i++) {
                    List<String> pair = pairs.get(i);
                    //if (isContain(pair, "1")) continue; // ㅋㅋ
                    for (int j = 0 ; j < lastTree.size() ; j++){
                        if (isContain(pair, lastTree.get(j))) {
                            tree.addAll(pair);
                        }
                    }
                }
                trees.add(tree.stream().distinct().sorted().collect(Collectors.toList()));
                treeCount++;
            }
        }
        System.out.println(removeOne(trees.get(trees.size() - 1)).size());
    }

    public static boolean isContain(List<String> arr, String num) {
        return arr.contains(num);
    }

    public static List<String> removeOne(List<String> arr) {
        return arr.stream().filter(num -> !"1".equals(num)).collect(Collectors.toList());
    }
}
