package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 그리디 알고리즘: 현재 상태에서 보는 선택지 중 최선의 선택지가 전체 선택지 중 최선의 선택지라고 가정하는 알고리즘
// 핵심 이론
// - 해 선택: 현재 상태에서 가장 최선이라고 생각되는 해를 선택
// - 적절성 검사: 현재 선택한 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사
// - 해 검사: 현재까지 선택한 해 집합이 전체 문제를 해결하라 수 있는지 검사, 전체 문제 해결하지 못하면 1로 돌아감


public class N32_동전개수의최솟값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N K 입력
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        // N개의 종류 -> 배열로
        int [] money = new int[N];
        for (int i=0; i<N; i++) {
            money[i] = Integer.parseInt(bufferedReader.readLine());
        }

        // 배열 내림차순으로 고를 수 있는 최대 개수 고르기
        int sum = 0;
        // int i=N-1; N-1부터 시작인걸 잊지말자 !!!!
        for (int i=N-1; i >= 0; i--) {
            int check = K / money[i];
            if (check >= 1) {
                sum = sum + check;
                K = K - check * money[i];
            }
        }

        // 합 구하기
        System.out.println(sum);
    }
}
