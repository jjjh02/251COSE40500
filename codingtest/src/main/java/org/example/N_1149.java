package org.example;

import java.util.*;
import java.io.*;

public class N_1149{
    static int[][] cost;
    static int[][] sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
//        for(int i=0; i<N; i++) {
//            System.out.println(cost[i][0] + " " + cost[i][1] + " " + cost[i][2]);
//        }
        sum = new int[N][3];
        sum[0][0] = cost[0][0];
        sum[0][1] = cost[0][1];
        sum[0][2] = cost[0][2];
        for(int i=1; i<N; i++) {
            sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + cost[i][0];
            sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + cost[i][1];
            sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + cost[i][2];
        }
//        for(int i=0; i<N; i++) {
//            System.out.println(sum[i][0] + " " + sum[i][1] + " " + sum[i][2]);
//        }
        int result = sum[N-1][0];
        for(int i=1; i<3; i++) {
            if(result > sum[N-1][i]) result = sum[N-1][i];
        }
        System.out.println(result);
    }
}