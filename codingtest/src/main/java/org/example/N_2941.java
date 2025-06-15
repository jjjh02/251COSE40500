package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if(i < s.length()-1) {
                if(s.charAt(i) == 'c') {
                    if(s.charAt(i+1) == '=' || s.charAt(i+1) == '-') i++;
                }
                else if(s.charAt(i) == 's' || s.charAt(i) == 'z') {
                    if(s.charAt(i+1) == '=') i++;
                }
                else if(s.charAt(i) == 'l' || s.charAt(i) == 'n') {
                    if(s.charAt(i+1) == 'j') i++;
                }
                else if(s.charAt(i) == 'd') {
                    if (s.charAt(i+1) == '=') i++;
                    else if(i < s.length()-2 && s.charAt(i+1) == 'z') {
                        if(s.charAt(i+2) == '=') i=i+2;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
