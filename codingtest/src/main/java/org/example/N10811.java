package org.example;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] intArr = new int[N+1];
        int start = 0;
        int end = 0;
        int tmp = 0;
        for(int i=1; i<=N; i++) {
            intArr[i] = i;
        }

        for(int i=0; i<M; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            for(int j=start; j<(start+end)/2f; j++) {
                tmp = intArr[j];
                intArr[j] = intArr[start+end-j];
                intArr[start+end-j] = tmp;
            }
        }

        for (int i=1; i<=N; i++) {
            System.out.print(intArr[i] + " ");
        }

    }
}