import java.io.*;
import java.util.ArrayList;

/**
 * @Description 제로
 */
public class _10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                nums.remove(nums.size() - 1);
            } else{
                nums.add(num);
            }
        }

        System.out.println(nums.stream()
                .mapToInt(i -> i)
                .sum());
    }
}
