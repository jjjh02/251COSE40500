package org.example;

import java.io.*;
import java.util.*;

// 계단수
// 9*2^100 = 1024*1024*9 = 10^7*9
// 1 2 3 4 5 6 7 8 9
// 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
// 101 121 123 210 212 232 234 321 323 343 345 432 434 454 456 543 545 565 567 654 656 676 678 765 767 787 789 876 878 898 987 989
// 마지막 단위 숫자가 0, 9 -> 1개 마지막 단위 숫자가 else -> 2개

// 결국 중요한것은 마지막 단위 숫자의 개수 -> 마지막 단위 숫자의 배열로 개수 저장

public class N_10844 {
    static long[] oldCheck;
    static long[] newCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        oldCheck = new long[10];
        newCheck = new long[10];
        oldCheck[0] = 0;
        for(int i=1; i<10; i++) {
            oldCheck[i] = 1;
        }
        newCheck = oldCheck.clone();
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<10; j++) {
                if(j==0) newCheck[j] = oldCheck[1];
                else if(j==9) newCheck[j] = oldCheck[8];
                else newCheck[j] = (oldCheck[j - 1] + oldCheck[j + 1]) % 1000000000;
            }
            oldCheck = newCheck.clone();
        }
        long sum = 0;
        for(int i=0; i<10; i++) {
            sum += newCheck[i] % 1000000000;
        }
        System.out.println(sum%1000000000);
    }
}
