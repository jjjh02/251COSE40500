package org.example;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

// Deque 알아보기
// static class?
// BufferedWriter는 결국 System.out이랑 같은 역할


// 12 3
// 1) 5) 2) 3) 6) 2 3 7 3 5 2 6
// 1  1  2  2  2
// S라는 배열에서,
// min = A_0, (min, min_index) 저장
// min<A_i, min_index>=i-2: min 유지
// min<A_i, min_index<i-2: 범위 내에서 새로운 min 찾기
// min>A_i, min_index :

// (index, number) 형태
// (2,5) (3,2) 처럼 number가 더 작은 경우에는 앞의 값 삭제
// (3,2) (4,3) 처럼 number가 더 큰 경우에는 그냥 추가
// index값이 지금 들어오는 index값과 3이상 차이나면 삭제

public class N10_최솟값찾기 {
    public static final Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        for (int i=0; i<N; i++){
            int now = Integer.parseInt(stringTokenizer.nextToken());

            while (!myDeque.isEmpty() && myDeque.getLast().value > now){
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(i, now));

            if(myDeque.getFirst().index <= i-L){
                myDeque.removeFirst();
            }
            bufferedWriter.write(myDeque.getFirst().value + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }
    static class Node{
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}



//public class N10_최솟값찾기 {
//    public static void main(String[] args) throws Exception{
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        Integer N = Integer.parseInt(stringTokenizer.nextToken());
//        Integer L = Integer.parseInt(stringTokenizer.nextToken());
//
//        Deque<Node> myDeque = new LinkedList<>();
//        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        for (int i=0; i<N; i++) {
//            Integer now = Integer.parseInt(stringTokenizer.nextToken());
//
//            if (!myDeque.isEmpty() && myDeque.getLast().value > now) {
//                myDeque.removeLast();
//            }
//            myDeque.addLast(new Node(i, now));
//
//            if (myDeque.getFirst().index < i-L){
//                myDeque.removeFirst();
//            }
//            bufferedWriter.write(myDeque.getFirst().value + " ");
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();
//
//    }
//    static class Node{ // public 말고 static
//        public int index;
//        public int value;
//
//        Node(int index, int value) {
//            this.index = index;
//            this.value = value;
//        }
//    }
//}



//public class N10_최솟값찾기 {
//    public static void main(String[] args) throws Exception{
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        Integer N = Integer.parseInt(stringTokenizer.nextToken());
//        Integer L = Integer.parseInt(stringTokenizer.nextToken());
//
//        Deque<Node> myDeque = new LinkedList<>();
//        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        for (int i=0; i<N; i++) {
//            int now = Integer.parseInt(stringTokenizer.nextToken());
//
//            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
//                myDeque.removeLast();
//            }
//            myDeque.addLast(new Node(i, now));
//
//            if (myDeque.getFirst().index <= i-L) {
//                myDeque.removeFirst();
//            }
//            bufferedWriter.write(myDeque.getFirst().value + " ");
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();
//    }
//
//    static class Node {
//        public int index;
//        public int value;
//
//        Node(int index, int value) {
//            this.index = index;
//            this.value = value;
//        }
//    }
//}




