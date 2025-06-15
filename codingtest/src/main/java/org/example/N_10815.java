package org.example;

import java.util.*;
import java.io.*;

public class N_10815{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> cardN = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cardN.add(Integer.parseInt(st.nextToken()));
        }
//        for(Integer card:cardN) {
//            System.out.print(card + " ");
//        }
        int M = Integer.parseInt(br.readLine());
//        System.out.println(M);
        int[] checkArr = new int[M];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            if(cardN.contains(Integer.parseInt(st1.nextToken()))) checkArr[i] = 1;
            else checkArr[i] = 0;
        }
        for(int i=0; i<M; i++) {
            System.out.print(checkArr[i]+" ");
        }
    }
}