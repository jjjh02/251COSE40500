package org.example;

import java.util.*;
import java.io.*;

public class N_10816 {
    static int[] cardArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stCard = new StringTokenizer(br.readLine());
        cardArr = new int[N];
        for(int i=0; i<N; i++) {
            cardArr[i] = Integer.parseInt(stCard.nextToken());
        }
        Arrays.sort(cardArr);
        int M = Integer.parseInt(br.readLine());
        int[] numArr = new int[M];
        int lb = 0, ub = 0;
        StringTokenizer stNum = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            numArr[i] = Integer.parseInt(stNum.nextToken());
            lb = lowerBound(0, N, numArr[i]);
            ub = upperBound(0, N, numArr[i]);
            System.out.println(lb + " " + ub);
            sb.append(ub - lb).append(" ");
        }

        System.out.println(sb);

    }

    // target 이상이 되는 최초 위치
    public static int lowerBound(int low, int high, int target) {
        if (low >= high) return low;
        int mid = (low+high)/2;
        if(cardArr[mid] < target) return lowerBound(mid+1, high, target);
        else return lowerBound(low, mid, target);
    }

    // target 초과가 되는 최초 위치
    public static int upperBound(int low, int high, int target) {
        if (low >= high) return low;
        int mid = (low+high)/2;
        if(cardArr[mid] <= target) return upperBound(mid+1, high, target);
        else return upperBound(low, mid, target);
    }
}


//public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    HashMap<Integer,Integer> numMap = new HashMap<>();
//    StringBuilder sb = new StringBuilder();
//    int cnt = 1;
//    for(int i=0; i<N; i++) {
//        int num = Integer.parseInt(st.nextToken());
//        if(numMap.containsKey(num)) {cnt = numMap.get(num)+1; numMap.put(num,cnt);}
//        else numMap.put(num, 1);
//    }
//    int M = Integer.parseInt(br.readLine());
//    st = new StringTokenizer(br.readLine());
//    for(int i=0; i<M; i++) {
//        int check = Integer.parseInt(st.nextToken());
//        if(numMap.containsKey(check)) sb.append(numMap.get(check)+" ");
//        else sb.append(0+ " ");
//    }
//    System.out.print(sb);
//}
