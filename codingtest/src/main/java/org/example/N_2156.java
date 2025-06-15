package org.example;

import java.io.*;
import java.util.*;

// 6
// x o o x o o
// 6 10 70 9 8 1 -> 89
// sum[-2] = 0
// sum[-1] = 0
// sum[0] = 6
// sum[1] = 10
// sum[1] = 10 (check = 0) x o
// sum[1] = 16 (check = 1) o o
// sum[2] = 70
// sum[2] = 76
// sum[2] = 80 (check = 1) x o o
// sum[2] = 16 (check = 0) o o x
// sum[3] = 15 o x x o
// sum[3] = 16+9 o o x o
// sum[3] = 6+70+9 (check = 1) o x o o
// sum[3] = 80 (check = 0)
// 3개 연달아 못 마심


// x x arr[i]: sum[i-3] + arr[i] -> 이건 최대가 될 수 없어서 제외 ( x x가 나와야할 이유가 없음 -> o x o o여도 됨 )
// o x arr[i]: sum[i-2] + arr[i] o x o
// x o arr[i]: sum[i-3] + arr[i-1] + arr[i] (if check = 0 -> check = 1) x o o
// o o arr[i]: sum[i-1] + 0 (if check = 1 -> check = 0) o o x


public class N_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N];
        int[] sumArr = new int[N];

        for(int i=0; i<N; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            if (i == 0) sumArr[i] = intArr[i];
            else if (i == 1) sumArr[i] = intArr[i-1] + intArr[i];
            else if (i == 2) sumArr[i] = Math.max(intArr[i-1]+intArr[i], Math.max(sumArr[i-2]+intArr[i], sumArr[i-1]));
            else sumArr[i] = Math.max(sumArr[i-3]+intArr[i-1]+intArr[i], Math.max(sumArr[i-2]+intArr[i], sumArr[i-1]));
        }

        System.out.println(sumArr[N-1]);
    }
}
