package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_BFSDFS {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;


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
