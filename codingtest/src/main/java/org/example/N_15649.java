package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15649 {
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] intArr; // 지나가는 노드 M개 저장하는 배열
    static boolean[] checkArr; // 1~N 중에 노드 지나감 여부(t/f) 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        intArr = new int[M];
        checkArr = new boolean[N+1];
        sb = new StringBuilder();

        backTracking(0);
        System.out.println(sb);
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
