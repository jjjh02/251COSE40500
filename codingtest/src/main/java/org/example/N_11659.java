package org.example;

import java.util.*;
import java.io.*;

public class N_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] intArr = new int[N+1];
        int[] sumArr = new int[N+1];
        sumArr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1]+ intArr[i];
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sumArr[end] - sumArr[start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
