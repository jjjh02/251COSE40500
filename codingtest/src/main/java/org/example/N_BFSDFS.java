package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_BFSDFS {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<Integer>();

        }
        for (int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]); // 작은 것부터 정렬
        }
        visited = new boolean[N+1];
        DFS(s);
        System.out.println();
        visited = new boolean[N+1];
        BFS(s);
        System.out.println();
    }

    public static void DFS(int node) { // DFS 구현하기
        System.out.print(node + " ");
        visited[node] = true;
        for (int i: graph[node]) { // node의 인접노드 중에서
            if (!visited[i]) { // 방문하지 않은 노드
                DFS(i); // DFS!
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node); // 노드 추가
        visited[node] = true;

        while (!queue.isEmpty()) { // 큐가 비지 않을때까지
            int nownode = queue.poll(); // 삭제된 value / 공백 큐이면 null 반환
            System.out.print(nownode + " ");
            for (int i : graph[nownode]) { // nownode의  인접노드 중에서
                if (!visited[i]) { // 방문하지 않은 노드
                    visited[i] = true;
                    queue.add(i); // 큐에 추가
                }
            }
        }
    }

}
