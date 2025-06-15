package org.example;
// 하.. 백준 제출할때는 이건 무조건 빼자,,

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// System.in -> InputStreamReader -> BufferedReader -> StringTokenizer

public class N37_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        // 에라토스테네스 방법
        // 2 ~ (N의 제곱근)까지 값 탐색 -> 배수면 0 처리

        int[] num = new int[N+1];
        for (int i=2; i<=N; i++) {
            num[i] = i;
        }
//        for (int i=0; i<=N; i++) {
//            System.out.println(num[i]);
//        }

        int end_num = (int)Math.sqrt(Double.valueOf(N));
//        System.out.println(end_num);

        for (int i=2; i<=end_num; i++) {
            // for (int j=i+i; j<=N; j++) 로 하면 안됨..
            // i의 배수가 아닌 숫자들도 포함될 수 있고, 이미 지워진 숫자들을 다시 처리하는 비효율
            // i*i 이전 것들은 이미 이전단계에서 지워짐,,
            for (int j=i+i; j<=N; j=j+i)
            {
                num[j] = 0;
            }
        }

        for (int i=M; i<=N; i++) {
            if(num[i] != 0)
                System.out.println(num[i]);
        }
    }
}
