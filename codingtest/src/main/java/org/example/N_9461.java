package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9461{
    static long[] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        mem = new long[101];
        pado();
        for(int i=0; i<T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(mem[num]).append("\n");
        }
        System.out.println(sb);
    }


    // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12
    // f(1) = 1, f(2) = 1, f(3) = 1, f(4) = 2, f(5) = 2
    // f(1)_1 + f(5)_2 = f(6)_3
    // f(2)_1 + f(6)_3 = f(7)_4
    // f(3)_1 + f(7)_4 = f(8)_5
    // f(4)_2 + f(8)_5 = f(9)_7
    // f(5)_2 + f(9)_7 = f(10)_9
    // f(6)_3 + f(10)_9 = f(11)_12
    public static void pado() {
        mem[1] = mem[2] = mem[3] = 1;
        mem[4] = mem[5] = 2;
        for(int i=6; i<101; i++) {
            mem[i] = mem[i-5] + mem[i-1];
        }
    }
}
