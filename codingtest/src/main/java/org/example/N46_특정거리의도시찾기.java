package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//List 선언하는 방법 다시 확인하기

// Scanner

//static List<Integer> result;
//result = new ArrayList<>();
//        -> 이것이 어떻게 되는건지


//Bfs, Dfs 코드 외우기

//Queue



public class N46_특정거리의도시찾기 {
    static ArrayList<Integer>[] graph;
    static int N, M, X, K;
    static List<Integer> results;
    static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N: 도시 개수, M: 도로 개수, K: 거리 정보, X: 출발도시 번호
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        // 1~N까지의 노드가 들어가는 arrayList 생성
        graph = new ArrayList[N+1]; // arraylist의 배열
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<Integer>(); // integer 타입의 arraylist
        }
        // 결과 리스트 초기화
        results = new ArrayList<>();

        // edge를 arrayList에 추가
        for (int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            graph[node1].add(node2);
        }

        // visited 배열 초기화
        visited = new int[N+1];
        for (int i=0; i<=N; i++) {
            visited[i] = 0;
        }

        // 시작노드(X)로 BFS
        BFS(X);

        // 끝까지 BFS 수행 후, 해당 거리에 잇는 node 반환
        for (int i=0; i<=N; i++) {
            if (visited[i] == K) {
                results.add(i);
            }
        }

        if (results.isEmpty()) { // results가 없는 경우
            System.out.println("-1");
        }
        else { // results가 있는 경우
            Collections.sort(results); // results 정렬
            for (int result:results) { // results에 있는 result 출력
                System.out.println(result);
            }
        }


    }

    private static void BFS(int node) {
        // queue를 linkedlist로 선언 ?
        Queue<Integer> queue = new LinkedList<Integer>();
        // queue에 node 추가
        queue.add(node);
        // visited 배열의 node 요소의 값 +1
        visited[node]++;

        while(!queue.isEmpty()) { // queue가 empty하기 전까지
            int now_node = queue.poll(); // queue의 맨앞 요소를 제거 + 반환
            for (int i: graph[now_node]) { // graph[now_node]에 있는 요소 루프
                if (visited[i] == -1) { // 만약 한번도 방문하지 X
                    visited[i] = visited[now_node] + 1; // +1해서 방문 표시 흐,
                    queue.add(i); // queue에 추가
                }
            }
        }
    }
}

