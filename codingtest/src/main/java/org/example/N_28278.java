package org.example;

import java.util.*;
import java.io.*;

public class N_28278 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(num == 2){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if(num == 3){
                sb.append(stack.size()).append("\n");
            }
            else if(num == 4){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else{
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}