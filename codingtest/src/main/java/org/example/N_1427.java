package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] intArr = new int[n];
        for(int i=0; i<n; i++) {
            intArr[i] = s.charAt(i)-'0';
        }
        Arrays.sort(intArr);
        for(int i=n-1; i>-1; i--) {
            System.out.print(intArr[i]);
        }
    }
}
