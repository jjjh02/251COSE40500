package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1920 {
    static int[] intArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        intArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            System.out.println(binarySearch(0, N-1, Integer.parseInt(st2.nextToken())));
        }

    }
    public static int binarySearch(int low, int high, int target) {
        if (low > high) return 0;
        int mid = (low+high)/2;
        if (intArr[mid] > target) return binarySearch(low, mid-1, target);
        else if (intArr[mid] < target) return binarySearch(mid+1, high, target);
        else return 1;
    }
}
