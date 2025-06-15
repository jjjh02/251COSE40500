package org.example;

import java.io.*;
import java.util.*;

// 52*200,000 = 10,400,000

public class N_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // charArr - 입력받은 문자열 charArray로 변환
        char[] charArr = s.toCharArray();
        int N = charArr.length;
        int Q = Integer.parseInt(br.readLine());

        int[][] alphaNum = new int[26][N];
        int[][] alphaSum = new int[26][N];

        // alphaNum - 26*N 배열로 char 존재 시, 해당 index에 1로 저장
        for(int i=0; i<26; i++) {
            for(int j=0; j<N; j++) {
                if(charArr[j] == 'a' + i) alphaNum[i][j] = 1;
            }
        }

//        StringBuilder sb0 = new StringBuilder();
//        for(int i=0; i<26; i++) {
//            for(int j=0; j<N; j++) {
//                sb0.append(alphaNum[i][j]).append(" ");
//            }
//            sb0.append("\n");
//        }
//
//        System.out.println(sb0);
//        System.out.println();

        // alphaSum - alphaNum의 누적합 배열
        for(int i=0; i<26; i++) {
            for(int j=0; j<N; j++) {
                if(j == 0) alphaSum[i][j] = alphaNum[i][j]; // j == 0인 경우, 범위 벗어남
                else alphaSum[i][j] += alphaSum[i][j-1] + alphaNum[i][j];
            }
        }

//        StringBuilder sb1 = new StringBuilder();
//        for(int i=0; i<26; i++) {
//            for(int j=0; j<N; j++) {
//                sb1.append(alphaSum[i][j]).append(" ");
//            }
//            sb1.append("\n");
//        }
//
//        System.out.println(sb1);

        // 결과를 위한 stringbuilder
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 입력
            char targetChar = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
//            System.out.println(targetChar + " " + start + end);
            // char -> int
            int alphaN = targetChar - 'a';
            // 누적합을 사용한 결과값 저장
            if(start == 0) sb.append(alphaSum[alphaN][end]).append("\n");
            else sb.append(alphaSum[alphaN][end] - alphaSum[alphaN][start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
