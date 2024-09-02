import java.io.*;
import java.util.*;

/**
 * @Description 웰컴 키트
 */
public class _30802 {

    private static int N, T, P; // N: 참가자 수, T: 티셔츠(장) 최소 묶음, P: 펜슬(자루) 최소 묶음
    private static int[] tSizes = new int[6]; // : 6가지 사이즈(S, M, L, XL, XXL, XXXL) 티셔츠 신청 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            tSizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        calculateT();
        calculateP();
    }

    static void calculateT(){
        int countT = 0;
        for (int i = 0; i < 6; i++) {
            countT += tSizes[i] / T;
            if (tSizes[i] % T != 0) countT++;
        }
        System.out.println(countT);
    }

    static void calculateP(){
        int countP1 = N / P;
        int countP2 = N % P;
        System.out.println(countP1 + " " + countP2);
    }
}
