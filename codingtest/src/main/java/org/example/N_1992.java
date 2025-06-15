package org.example;

import java.io.*;
import java.util.*;

public class N_1992 {
    static int[][] intArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        intArr = new int[N][N];
        for(int i=0; i<N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine()); // 1 1 1 0 0 이런식으로 공백으로 구분될때만 동작
            String line = br.readLine(); // 한 줄을 string으로 받기
            for(int j=0; j<N; j++) {
                intArr[i][j] = line.charAt(j) - '0'; // 해당 줄을 charArr로 분리 후 정수화
            }
        }
        quadTree(N, 0, 0);
    }
    public static void quadTree(int size, int x, int y) {
        int check = intArr[x][y];
        boolean isSame = true;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                // 헷갈린 부분: 여기서 break하고 나와서 분할한다고 생각했는데 (이게 맞음)
                // 한번에 break;하고 나올 수 없으니
                // isSame으로 같은지 여부 확인 + 필요한 이유) 분할할때 확인해야하므로
                if(intArr[x+i][y+j] != check) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }

        // 출력은 어떻게?
        if(isSame) { // 모두 같으면 출력
            System.out.print(check);
        }
        else { // 다르면
            System.out.print("(");
            quadTree(size/2, x, y); // 왼쪽 위
            quadTree(size/2, x, y+size/2); // 오른쪽 위
            quadTree(size/2, x+size/2, y); // 왼쪽 아래
            quadTree(size/2, x+size/2, y+size/2); // 오른쪽 아래
            System.out.print(")");
        }
    }
}
