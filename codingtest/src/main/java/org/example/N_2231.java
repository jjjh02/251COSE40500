package org.example;

import java.util.*;
import java.io.*;

public class N_2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        int sum = 0;
        int result = 0;
        for(int i=0; i<N; i++) {
            sum = 0;
            String s_i = i + "";
            for(int j=0; j<s_i.length(); j++)
            {
                sum+=s_i.charAt(j)-'0';
            }
            sum+=i;
            if(sum == N) {result = i; break;}
        }
        System.out.println(result);
    }
}
