package org.example;

import java.util.Scanner;

public class N_2738{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] intArr = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                intArr[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                intArr[i][j] += sc.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(intArr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
