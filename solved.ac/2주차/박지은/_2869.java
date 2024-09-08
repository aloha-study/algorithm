import java.io.*;

/**
 * @Description 달팽이는 올라가고 싶다
 */
public class _2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]); // up
        int B = Integer.parseInt(str[1]); // down
        int V = Integer.parseInt(str[2]); // goal

        // 풀이1
        int day = (V - B) / (A - B);
        if( (V - B) % (A - B) != 0 ){
            day++;
        }

//        // 풀이2
//        int day = 0;
//        int remain = (V - A) % (A - B);
//        if( remain == 0 ){
//            day = (V - A) / (A - B) + 1;
//        } else{
//            day = (V - A) / (A - B) + 2;
//        }

        System.out.println(day);
    }
}
