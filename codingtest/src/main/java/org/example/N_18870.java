package org.example;

import java.util.*;
import java.io.*;

public class N_18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer, Integer> intList = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            intArr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sortedArr);
        int cnt = 0;
        for (int i=0; i<N; i++) {
            if(!intList.containsKey(sortedArr[i])) {
                intList.put(sortedArr[i], cnt);
                cnt++;
            }
        }
        for (int v: intArr) {
            System.out.print(intList.get(v)+ " ");
        }
    }
}