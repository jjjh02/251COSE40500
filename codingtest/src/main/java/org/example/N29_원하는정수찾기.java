package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5
//4 1 5 2 3
//5
//1 3 7 9 5



public class N29_원하는정수찾기 {


    public static void main(String[] args) throws IOException {
        // 계속 입력 오류가 떠서 확인해보니 다른 파일 실행중이었음,,,
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] num1 = new int[N];
        for (int i=0; i<N; i++) {
            num1[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(num1);

        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] num2 = new int[M];
        int [] check = new int[M];
        for (int i=0; i<M; i++) {
            num2[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i=0; i<M; i++) {
            check[i] = 0;
        }

        // 이진 탐색
        // ** while (start <= end) **
        // num1 정렬 + start, end index 선언

        // 중앙값 선언 : 중앙값은 num1[(start+end)/2]
        // 중앙값 탐색
        // (중앙값 > x : end = (start+end)/2 + 1 (*) | 중앙값 < x : start = (start+end)/2 - 1 (*) | 중앙값 == x : 탐색 성공, break)

        for (int i=0; i<M; i++) {
            int start = 0;
            int end = N-1;

            while (start <= end) {
                int midi = (start + end) / 2;
                if (num1[midi] > num2[i]) {
                   end = midi - 1;
                }
                else if (num1[midi] < num2[i]) {
                    start = midi + 1;
                }
                else { // num1[mid] == num2[i]
                    check[i] = 1;
                    break;
                }
            }
            System.out.println(check[i]);
        }

    }
}
