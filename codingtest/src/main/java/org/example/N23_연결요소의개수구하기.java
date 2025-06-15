package org.example;

// 그래프는 인접행렬이나 인접리스트 (여기서는 인접리스트)
// 인접리스트는 결국 형태가 ArrayList<ArrayList<Integer>>
// 간선이 많으면 인접행렬, 간선이 적으면 인접리스트

// static이 뭔지?
// 객체를 생성하지 않고 바로 사용 가능함.
// 정적 필드는 객체 간 공유 변수의 성질이 있다

// array, arraylist 차이
// array 고정된 길이, arrayList 가변적 길이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N23_연결요소의개수구하기 {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    public static void main(String [] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        int cnt = 0;
        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int v){
        if(!visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i: graph[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}

//public class N23_연결요소의개수구하기 {
//    // 아래 DFS class에서도 사용하기 위해 밖으로 뺌
//    static ArrayList<Integer> []  graph;
//    static boolean [] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        int N = Integer.parseInt(stringTokenizer.nextToken());
//        int M = Integer.parseInt(stringTokenizer.nextToken());
//
//        graph = new ArrayList[N+1];
//        visited = new boolean[N+1];
//
//        for (int i=1; i<N+1; i++){
//            graph[i] = new ArrayList<Integer>();
//        }
//
//        for (int i=0; i<M; i++){
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            int node1 = Integer.parseInt(stringTokenizer.nextToken());
//            int node2 = Integer.parseInt(stringTokenizer.nextToken());
//            graph[node1].add(node2);
//            graph[node2].add(node1);
//        }
//        int cnt = 0;
//
//        for(int i=1; i<N+1; i++) {
//            if (!visited[i]) { // 방문하지 않은 노드가 있으면
//                cnt++; // cnt 증가
//                DFS(i); // DFS 시작
//            }
//        }
//        System.out.println(cnt);
//    }
//
//    static void DFS(int v) {
//        if (visited[v]) { // 방문을 했으면
//            return; // 함수를 실행했던 위치로 돌아가라
//        }
//        visited[v] = true;
//        for (int i : graph[v]) { // v라는 노드와 연결된 다른 노드 중에서
//            if (visited[i] == false) { // 방문하지 않은 노드만 탐색
//                DFS(i); // 재귀함수
//            }
//        }
//    }
//}
