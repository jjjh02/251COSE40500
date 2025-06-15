package org.example;

import java.util.*;
import java.io.*;

public class N_12789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N+1];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = true;
        int num = 1;
        int idx = 1;
        while(num <= N) {
            if(idx <= N && intArr[idx] == num) { // 현재 줄 서있는 곳 사람과 num이 일치
                idx++; // 현재 줄 서있는 곳에서 사람 나감
                num++; // 다음 숫자로 넘어가기
            }
            else if(!stack.isEmpty() && stack.peek() == num) { // 한명씩만 서있는 곳 사람과 num이 일치 + 한명씩만 서있는 곳이 비지 않음
                stack.pop(); // 한명씩만 서있는 곳에서 사람 나감
                num++; // 다음 숫자로 넘어가기
            }
            else{ // 둘 다 아닌 경우
                if(idx > N || (!stack.isEmpty() && stack.peek() < intArr[idx]) || stack.isEmpty()) {
                    result = false;
                    break;
                }
                stack.push(intArr[idx]); // 현재 줄 서있는 곳 사람을 한명씩만 서있는 곳으로 보냄
                idx++; // 현재 줄 서있는 곳 다음 사람 확인
            }
        }
        if(result) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
