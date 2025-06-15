package org.example;

import java.util.*;
import java.io.*;

// 1. 8*8을 자르는 방법
// 2. 8*8안에 다시 칠해야하는 정사각형 개수 세는 방법
import java.util.*;
import java.io.*;

public class N_1018 {
    public static void main(String[] args) throws IOException{
        char[][] chess1 = {
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        };
        char[][] chess2 = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        char[][] board = new char[n1][n2];

        for(int i=0; i<n1; i++) {
            String s = br.readLine();
            for(int j=0; j<n2; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int result = 64;
        int check = 0;
        for(int i=0; i<n1-7; i++){
            for(int j=0; j<n2-7; j++) {
                check = check(i, j, board, chess1, chess2);
                if(result > check) result = check;
            }
        }
        System.out.println(result);
    }

    public static int check(int n1, int n2, char[][] board, char[][] chess1, char[][] chess2) {
        int cnt1=0;
        int cnt2=0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(board[n1+i][n2+j] != chess1[i][j]) cnt1+=1;
                if(board[n1+i][n2+j] != chess2[i][j]) cnt2+=1;
            }
        }
        if(cnt1<cnt2) return cnt1;
        else return cnt2;
    }
}
