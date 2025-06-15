package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class N47_효율적으로해킹하기 {
    static int N, M;
    static ArrayList<Integer> [] graph;
    static int[] visited;
    static int [] check;

    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            graph[node2].add(node1);
        }

        int [] check = new int[N+1];
        int max = 0;
        for (int i=1; i<=N; i++) {
            check[i] = BFS(i);
            if (max < check[i]) {
                max = check[i];
            }
        }

        for (int i=1; i<=N; i++) {
           if (check[i] == max) {
               System.out.print(i + " ");
           }
        }
    }

    public static int BFS(int node) {
        visited = new int[N+1];
        for (int i=0; i<=N; i++) {
            visited[i] = 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int check_i = 1;
        visited[node] = 1;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i: graph[now_node]) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    check_i = check_i + 1;
                    queue.add(i);
                }
            }
        }
        return check_i;
    }
}
