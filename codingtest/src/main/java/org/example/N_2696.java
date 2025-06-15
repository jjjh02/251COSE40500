package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int count = 0;
            int printed = 0; // 10개 출력시 줄바꿈을 위해 필요
            StringTokenizer st = new StringTokenizer("");

            while (count < M) {
                // 다 입력 받았으면 다음 줄에서 새로 읽기
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                // 힙 삽입
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                if (maxHeap.size() > minHeap.size() + 1) { // maxHeap이랑 minHeap의 크기 차이가 1이상 발생시
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) { // minHeap이 maxHeap의 크기보다 커질 시
                    maxHeap.add(minHeap.poll());
                }

                count++;

                // 홀수 번째 수일 때만 중앙값 출력
                if (count % 2 == 1) {
                    sb.append(maxHeap.peek()).append(" ");
                    printed++;
                    if (printed % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }

            if (printed % 10 != 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
