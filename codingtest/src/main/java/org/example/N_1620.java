package org.example;

import java.io.*;
import java.util.*;

public class N_1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 1;
        HashMap<String,Integer> monMap = new HashMap<>();
        String[] monArray = new String[N+1];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            monMap.put(s, cnt);
            monArray[i+1] = s;
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String p = br.readLine();
            try{
                sb.append(monArray[Integer.parseInt(p)]).append("\n");
            }
            catch(Exception e) {
                sb.append(monMap.get(p)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
