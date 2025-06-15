package org.example;

import java.util.*;
import java.io.*;

public class N_1260 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited_BFS;
    static boolean[] visited_DFS;
    static StringBuilder sb_dfs;
    static StringBuilder sb_bfs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited_BFS = new boolean[N+1];
        visited_DFS = new boolean[N+1];

        for(int i=0; i<M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st1.nextToken());
            int n2 = Integer.parseInt(st1.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        sb_dfs = new StringBuilder();
        sb_bfs = new StringBuilder();

        DFS(V);
        BFS(V);
        System.out.println(sb_dfs);
        System.out.println(sb_bfs);
    }

    public static void DFS(int start) {
        visited_DFS[start] = true;
        sb_dfs.append(start).append(" ");
        for(int num:graph[start]) {
            if(!visited_DFS[num]) DFS(num);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited_BFS[start] = true;
        while(!queue.isEmpty()) {
            int check = queue.poll();
            sb_bfs.append(check).append(" ");
            for(int num: graph[check]) {
                if(!visited_BFS[num]) {
                    visited_BFS[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}


//
//public class N_1260{
//    static ArrayList<Integer>[] graph;
//    static boolean[] visited_dfs;
//    static boolean[] visited_bfs;
//    static StringBuilder sb_dfs = new StringBuilder();
//    static StringBuilder sb_bfs = new StringBuilder();
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int start = Integer.parseInt(st.nextToken());
//        graph = new ArrayList[N+1];
//        visited_dfs = new boolean[N+1];
//        visited_bfs = new boolean[N+1];
//        for(int i=1; i<N+1; i++) {
//            graph[i] = new ArrayList<Integer>();
//        }
//        for(int i=0; i<M; i++) {
//            StringTokenizer st_line = new StringTokenizer(br.readLine());
//            int num1 = Integer.parseInt(st_line.nextToken());
//            int num2 = Integer.parseInt(st_line.nextToken());
//            graph[num1].add(num2);
//            graph[num2].add(num1);
//        }
//        for (int i = 1; i <= N; i++) {
//            Collections.sort(graph[i]);
//        }
//        DFS(start);
//        BFS(start);
//
//        System.out.println(sb_dfs);
//        System.out.println(sb_bfs);
//    }
//
//    //1. 방문으로 전환
//    //2. 정답에 추가
//    //3. 인접 노드들 중 아직 안 간 곳 재귀로 방문
//    public static void DFS(int node){
//        visited_dfs[node] = true;
//        sb_dfs.append(node).append(" ");
//        for(int i: graph[node]) {
//            if(!visited_dfs[i]) DFS(i);
//        }
//    }
//
//    //1. 큐 선언, 시작 노드 큐에 넣음, 방문으로 전환
//    //2. 큐가 빌 때까지 반복:
//    // - 하나 꺼내서 출력
//    // - 인접 노드들 중 아직 안 간 곳 방문 표시하고 큐에 추가
//    public static void BFS(int node) {
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.add(node);
//        visited_bfs[node] = true;
//        while(!queue.isEmpty()) {
//            int check = queue.poll();
//            sb_bfs.append(check).append(" ");
//            for(int i: graph[check]) {
//                if(!visited_bfs[i]) {
//                    visited_bfs[i] = true;
//                    queue.add(i);
//                }
//            }
//        }
//    }
//
//
//}