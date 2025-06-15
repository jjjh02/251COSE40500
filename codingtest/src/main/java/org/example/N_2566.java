package org.example;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2566 {
    public static void main(String[] args) throws IOException{
        char[][] charArr = new char[5][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        String s;
        for (int i=0; i<5; i++) {
            s = br.readLine();
            cnt = s.length();
;            for (int j=0; j<cnt; j++) {
                charArr[i][j] = s.charAt(j);
            }
            for (int k=cnt; k<15; k++) {
                charArr[i][k] = '-';
            }
        }

        for (int i=0; i<15; i++) {
            for (int j=0; j<5; j++) {
                if (charArr[j][i] != '-') System.out.print(charArr[j][i]);
            }
        }

    }
}