package org.example;

// 5a+3b = N (a+b가 최소)
import java.util.*;
import java.io.*;

public class N_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = N/5;
        int b = 0;
        int sum = 1666;
        for(int i=0; i<=a; i++) {
            if((N-5*i)%3==0) {
                b=(N-5*i)/3;
                System.out.println(b+ " "+ a+b);
                if(sum > i+b) sum = i+b;
            }
        }
        if(sum == 1666) System.out.println(-1);
        else System.out.println(sum);
    }
}
