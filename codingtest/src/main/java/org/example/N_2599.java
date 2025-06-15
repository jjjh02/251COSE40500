package org.example;

import java.util.*;
import java.io.*;

public class N_2599 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] intArr = new int[N];
        int[] sumArr = new int[N-M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            sumArr[0] += intArr[i];
        }
        for(int i=1; i<=N-M; i++) {
            sumArr[i] = sumArr[i-1] - intArr[i-1] + intArr[i+M-1];
        }
        Arrays.sort(sumArr);
        System.out.print(sumArr[N-M]);
    }
}