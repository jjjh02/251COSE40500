package org.example;

import java.util.*;
import java.io.*;

public class N_10773{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        for(int n:stack){
            sum += n;
        }
        System.out.println(sum);
    }
}
