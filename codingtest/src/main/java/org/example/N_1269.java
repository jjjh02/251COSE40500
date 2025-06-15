package org.example;

import java.util.*;
import java.io.*;

public class N_1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        HashSet<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }
        for(Integer a: aSet){
            if(bSet.contains(a)) M--;
        }
        for(Integer b: bSet){
            if(aSet.contains(b)) N--;
        }
        System.out.print(N+M);
    }
}

