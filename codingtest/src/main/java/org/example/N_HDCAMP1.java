package org.example;

import java.io.*;
import java.util.*;

public class N_HDCAMP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // Deque 선언 방식
        // datatype: Character
        Deque<Character> charList = new LinkedList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().charAt(0) == 'L') charList.addFirst(st.nextToken().charAt(0));
            else charList.addLast(st.nextToken().charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:charList) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
