package org.example;

import java.util.*;
import java.io.*;

public class N_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int num = 0;
        while(cnt < N) {
            num++;
            if(check(num)) cnt++;
        }
        sc.close();
        System.out.println(num);
    }
    public static boolean check(int num) {
        String s = num+"";
        boolean result = false;
        for(int i=0; i<s.length()-2; i++) {
            if(s.charAt(i) == '6' && s.charAt(i+1) == '6' && s.charAt(i+2) == '6' ) result = true;
        }
        return result;
    }
}
