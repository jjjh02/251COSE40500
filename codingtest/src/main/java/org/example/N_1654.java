//package org.example;
//
//import java.io.*;
//import java.util.*;
//
//public class N_1654 {
//    static int[] lengthArr;
//    static int K;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        K = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//        lengthArr = new int[K];
//        int min = 0;
//        for(int i=0; i<K; i++) {
//            lengthArr[i] = Integer.parseInt(br.readLine());
//            if(i == 0 || lengthArr[i]< min) min = lengthArr[i];
//        }
//        System.out.println(min);
//
//
//    }
//    public static int binarySearch(int start, int end) {
//        if(start >= end) return start;
//        int mid = (start+end)/2;
//        if(checkCase(mid)) binarySearch(mid, end);// n을 키워도 됨
//        else binarySearch(start, mid-1);// n을 줄여야 함
//
//    }
//
//    // upperbound (target이 초과되는 첫 시기)
//    public static boolean checkCase(int n){
//        int sum = 0;
//        for(int i=0; i<K; i++) {
//            sum += lengthArr[i]/n;
//        }
//        return N > sum;
//    }
//}
