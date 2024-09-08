import java.io.*;
import java.math.BigInteger;

/**
 * @Description Hashing
 */

public class _15829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int M = 1234567891;

        // 모듈러 연산 결합 법칙 : (A * B) % m = (A % m) x (B % m) % m

        // 풀이1
        long pow = 1;
        long result = 0;
        for (int i = 0 ; i < N ; i++){
            // a ASCII : 97
            int num = str.charAt(i) - 96;

            result += (num * pow) % M;
            pow = (31 * pow) % M;
        }
        System.out.println(result % M);

//        // 풀이2
//        BigInteger result2 = BigInteger.valueOf(0);
//        for (int i = 0 ; i < N ; i++){
//            int num = str.charAt(i) - 96;
//            result2 = result2.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(31).pow(i)));
//        }
//        System.out.println(result2.remainder(BigInteger.valueOf(M)));
    }
}
