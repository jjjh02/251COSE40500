package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_1904 {
    static int[] mem;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mem = new int[N+1];

        tileCase(N);
        System.out.println(mem[N]);
    }

    public static int tileCase(int n) {
        if(n == 1 || n == 2) return n;
        else if(mem[n] != 0) return mem[n];
        else return mem[n] =  (tileCase(n-1) + tileCase(n-2)) % 15746;
    }
}

//static int[] memo;
//public static void main(String[] args) throws IOException {
//    final int MOD = 15746;
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//
//    memo = new int[N + 1];
//    Arrays.fill(memo, -1);
//
//    System.out.println(tileCase(N, MOD));
//}
//
//public static int tileCase(int n, int MOD) {
//    if (n == 1) return 1;
//    if (n == 2) return 2;
//    if (memo[n] != -1) return memo[n];
//    return memo[n] = (tileCase(n - 1, MOD) + tileCase(n - 2, MOD)) % MOD;
//}

//public static void main(String[] args) throws IOException {
//    // 1이나 00으로 N의 길이만큼 연결해서 나올 수 있는 개수 % 15746
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//
//    System.out.println((tileCase(N, 1)+1) % 15746);
//}
//
//// N=1 1 "1"
//// N=2 00, 11 "2"
//// N=3 100, 111, 001 "3" (1+00, 00+1, 1+00, 00+1, 11+1, 1+11)
//// N=4 0011, 0000, 1001, 1100, 1111 (00+00, 00+00, 11+00, 00+11, 1+100, 100+1, 111+1, 1+111, 001+1, 1+001)
//
//// f(n-2) + 00 / 00 + f(n-2)
//// f(n-1) + 1 / 1 + f(n-1)
//// f(n) = f(n-1) * 2 + f(n-2) * 4
//
//// N!/N! + (N-1)!/(N-2)! + (N-3)!/((N-4)!*2!)+ .. = 1 + (N-1)/1! + (N-3)/2! + ..
//public static int tileCase(int N, int n) {
//    if(N-2*n+1 == 1) return 1;
//    if(N-2*n+1 == 0) return 0;
//    return tileCase(N, n+1)+(N-2*n+1)/factorial(n)% 15746;
//}
//
//public static int factorial(int n) {
//    if(n==1) return 1;
//    return n*factorial(n-1);
//}
