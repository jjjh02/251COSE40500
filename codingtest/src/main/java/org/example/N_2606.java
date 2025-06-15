//package org.example;
//
//import java.io.*;
//import java.util.*;
//
//public class N_2606{
//    static ArrayList<Integer>[] graph;
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        graph = new ArrayList[N+1];
//        visited = new boolean[N+1];
//        for(int i=1; i<N+1; i++) {
//            graph[i] = new ArrayList<Integer>();
//        }
//        for(int i=0; i<M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int num1 = Integer.parseInt(st.nextToken());
//            int num2 = Integer.parseInt(st.nextToken());
//            graph[num1].add(num2);
//            graph[num2].add(num1);
//        }
//        BFS(1);
//        int cnt = 0;
//        for(int i=1; i<N+1; i++) {
//            if(visited[i]) cnt++;
//        }
//        System.out.println(cnt-1);
//    }
//
//    public static void BFS(int node){
//        visited[node] = true;
//        for(int i: graph[node]) {
//            if(!visited[i]) {
//                BFS(i);
//            }
//        }
//    }
//}