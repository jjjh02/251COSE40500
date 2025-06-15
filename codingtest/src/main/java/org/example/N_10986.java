package org.example;

import java.util.*;
import java.io.*;

public class N_10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[N+1];
        int[] remArr = new int[M];
        long result = 0;
        st = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) {
            sumArr[i] = (sumArr[i-1] + Integer.parseInt(st.nextToken())) % M;
        }
        for(int i=1; i<N+1; i++) {
            remArr[sumArr[i]]++;
        }
        result += remArr[0];
        for(int i=0; i<M; i++) {
            if(remArr[i] > 1) {
                result += (remArr[i]*(remArr[i]-1))/2;
            }
        }
        System.out.println(result);
    }
}
