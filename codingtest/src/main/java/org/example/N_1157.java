package org.example;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = new int[26];
        for(int i=0; i<26; i++) {
            intArr[i] = 0;
        }
        String s = br.readLine().toUpperCase();
        for(int i=0; i<s.length(); i++) {
            intArr[s.charAt(i)-'A']++;
        }
        int max = 0;
        int index = -1;
        boolean check = true;
        for(int i=0; i<26; i++) {
            if(intArr[i] == max) {
                check = false;
            }
            if(intArr[i] > max) {
                check = true;
                max = intArr[i];
                index = i;
            }
        }
        if(check) System.out.println((char)('A'+index));
        else System.out.println('?');
    }
}
