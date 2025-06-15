package org.example;

import java.util.*;
import java.io.*;

public class N_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        HashSet<String> nameSet = new HashSet<>();
        for(int i=0; i<N; i++) {
            nameSet.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(nameSet.contains(s)) {
                sb.append(s).append("\n");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
