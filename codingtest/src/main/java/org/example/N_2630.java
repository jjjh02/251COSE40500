package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2630 {
    static int[][] intArr;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        intArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                intArr[i][j] = Integer.parseInt(input[j]);
            }
        }

        divideSquare(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void divideSquare(int x, int y, int size) {
        if(checkSquare(x,y,size)) {
            if(intArr[x][y] == 0) whiteCount++;
            else blueCount++;
            return;
        }
        int newSize = size/2;
        divideSquare(x, y, newSize);
        divideSquare(x, y+newSize, newSize);
        divideSquare(x+newSize, y, newSize);
        divideSquare(x+newSize, y, newSize);
    }

    public static boolean checkSquare(int x, int y, int size) { // 인수로 시작좌표, 끝좌표가 있어야하나
        int check = intArr[x][y];
        // 내부가 모두 같은 숫자인지 확인
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(check != intArr[i][j]) return false;
            }
        }
        return true;
    }
}
