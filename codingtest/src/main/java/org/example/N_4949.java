package org.example;

import java.util.*;
import java.io.*;

public class N_4949{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean result = true;
        while(true) {
            result = true;
            String s = br.readLine();
            if(s.equals(".")) break;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == ')') {
                    if(stack.isEmpty() || stack.peek() != 1) {
                        result = false;
                        break;
                    }
                    else stack.pop();
                }
                else if(s.charAt(j) == ']') {
                    if(stack.isEmpty() || stack.peek() != 2) {
                        result = false;
                        break;
                    }
                    else stack.pop();
                }
                else if(s.charAt(j) == '(') stack.push(1);
                else if(s.charAt(j) == '[') stack.push(2);
            }
            if(!stack.isEmpty()) result = false;
            if(result) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}
