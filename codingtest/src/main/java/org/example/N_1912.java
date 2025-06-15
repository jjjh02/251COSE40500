package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] check = new long[N+1];
        check[0] = 0;
        long max = -1000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(check[i-1] + num > num) check[i] = check[i-1] + num; // 앞의 누적합을 더하는게 해당 수를 더 크게 만든다 -> 더함
            else check[i] = num; // 앞의 누적합을 더하는게 해당 수를 더 작게 만든다 -> 더하지 않음
            if(check[i] > max) max = check[i];
        }
        System.out.println(max);
    }
}
