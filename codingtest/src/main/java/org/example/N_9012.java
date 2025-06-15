package org.example;

import java.util.*;
import java.io.*;

public class N_9012{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean result = true;
        for(int i=0; i<T; i++) {
            result = true;
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == ')') {
                    if(stack.isEmpty()) {
                        result = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else stack.push(1);
            }
            if(!stack.isEmpty()) result = false;
            if(result) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
            stack.clear();
        }
        System.out.print(sb);
    }
}

