package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2667 {
    static boolean[][] graph;
    static boolean[][] visited;
    static int[][] direction = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    static int N;
    static int cnt_each;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt_total = 0;
        cnt_each = 1;
        StringBuilder sb = new StringBuilder();
        graph = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String br_line = br.readLine();
            for(int j=0; j<N; j++) {
                graph[i][j] = br_line.charAt(j) != '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(graph[i][j] && !visited[i][j]) {
                    cnt_total++;
                    DFS(i, j);
                    sb.append(cnt_each);
                    cnt_each = 1;
                }
            }
        }
        System.out.println(cnt_total);
        System.out.println(sb);
    }

    public static void DFS(int start_i, int start_j) {
        visited[start_i][start_j] = true;
        for(int i=0; i<4; i++) {
            int check_i = start_i + direction[i][0];
            int check_j = start_j + direction[i][1];
            if(check_i >= 0 && check_j >=0 && check_i < N && check_j < N && graph[check_i][check_j] && !visited[check_i][check_j]) {
                cnt_each++;
                DFS(check_i, check_j);
            }
        }
    }
}
