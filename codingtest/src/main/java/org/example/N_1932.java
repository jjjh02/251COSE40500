package org.example;

import java.io.*;
import java.util.*;

// 0 [0][0]
// 0 1 [1][0] [1][1]
// 0 1 2
// 0 1 2 3

// max(sum[i-1][j-1], sum[i-1][j]) + num[i][j]

public class N_1932 {
    static int[][] num;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        sum = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(i==0) {sum[i][j] = num[i][j]; continue;}
                if(j==0) sum[i][j] = sum[i-1][j] + num[i][j];
                else sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + num[i][j];
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            if(max < sum[N-1][i]) max = sum[N-1][i];
        }

        System.out.println(max);
    }
}
