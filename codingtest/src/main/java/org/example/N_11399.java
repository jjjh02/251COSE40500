package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5
// 3 1 4 3 2
// 32

// 1 + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4) = 1 + 3 + 6 + 9 + 13 = 32
// 1. (가장 작은 수) * N

public class N_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        for(int i=0; i<N; i++) {
            sum += intArr[i] * (N-i);
        }
        System.out.println(sum);
    }
}

