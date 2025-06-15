package org.example;

import java.util.*;
import java.io.*;

public class N_1780{
    static int[][] intArr;
    static int numzero, numpositiveone, numnegativeone = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                intArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkNum(N, 0, 0);
        System.out.println(numnegativeone);
        System.out.println(numzero);
        System.out.println(numpositiveone);
    }

    public static void checkNum(int size, int x, int y) {
        int check = intArr[x][y];
        boolean isSame = true;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (intArr[i][j] != check) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) {
                break;
            }
        }
        if (isSame) {
            if (check == -1) numnegativeone++;
            else if (check == 0) numzero++;
            else numpositiveone++;
        }
        else {
            checkNum(size/3, x, y);
            checkNum(size/3, x+size/3, y);
            checkNum(size/3, x+2*size/3, y);
            checkNum(size/3, x, y+size/3);
            checkNum(size/3, x+size/3, y+size/3);
            checkNum(size/3, x+2*size/3, y+size/3);
            checkNum(size/3, x, y+2*size/3);
            checkNum(size/3, x+size/3, y+2*size/3);
            checkNum(size/3, x+2*size/3, y+2*size/3);
        }
    }

}
