package org.example;

import java.util.*;
import java.io.*;

public class N_15650 {
    static int N;
    static int M;
    static int[] intArr;
    static boolean[] checkArr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        intArr = new int[M+1];
        checkArr = new boolean[N+1];
        intArr[0] = 0;

        backTracking(1);
        System.out.println(sb);
    }
    public static void backTracking(int num) {
        if(num == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(intArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!checkArr[i] && (intArr[num-1] < i)) {
                checkArr[i] = true;
                intArr[num] = i;
                backTracking(num+1);
                checkArr[i] = false;
            }
        }
    }
}