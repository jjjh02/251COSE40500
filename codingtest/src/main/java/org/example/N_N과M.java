package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//        1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

public class N_N과M {
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] intArr; // 지나가는 노드 M개 저장하는 배열
    static boolean[] checkArr; // 1~N 중에 노드 지나감 여부(t/f) 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    }

    public static void backTracking(int num) {
        if(num == M) { // M개 모두 지나간 경우
            for(int i=0; i<M; i++) {
                sb.append(intArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!checkArr[i]) {
                intArr[num] = i; // 지나가는 노드에 저장
                checkArr[i] = true; // 지나갔으니 지나감 true로 설정
                backTracking(num+1);
                checkArr[i] = false; // 다음 차례를 위해 지나감 false로 되돌림
            }
        }


    }
}
