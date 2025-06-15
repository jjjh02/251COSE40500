package org.example;


// break;의 역할 -> 얘를 감싸고 있는 가장 작은 반복문이 중단됨
// class란 무엇인지
// bufferedReader.close 꼭 해야하는지 -> 안해도 괜찮지만 하는걸 권장 (gc가 있어서.. - Garbage Collector)

// long []
// { N(N-1)/2 -> 2000*1999/2 = 1999000 (10^6) } * N = N^3 => 안됨

// 투 포인터 이동 원칙
// A[i] + A[j] > K: j--; A[i] + A[j] < K: i++;
// A[i] + A[j] == K: i++; j--; count++; // 프로세스 종료

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class N8_좋은수 {
//    public static void main (String[] args) throws Exception {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(bufferedReader.readLine());
//        long [] S = new long[N];
//
//        int cnt = 0;
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        for (int i = 0; i<N; i++) {
//            S[i] = Long.parseLong(stringTokenizer.nextToken());
//        }
//        Arrays.sort(S);
//
//        for (int i=0; i<N; i++) {
//            long num = S[i];
//            int k = 0;
//            int l = N-1;
//
//            while (k<l) {
//                if (S[k] + S[l] == num){
//                    if (k != i && l != i){
//                        cnt++;
//                        break;
//                    }
//                    else if (k == i) {
//                        k++;
//                    }
//                    else {
//                        l--;
//                    }
//                }
//                else if (S[k] + S[l] > num) {
//                    l--;
//                }
//                else {
//                    k++;
//                }
//            }
//        }
//
//        System.out.println(cnt);
//        bufferedReader.close();
//
//    }
//}

public class N8_좋은수 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        long [] S = new long[N];

        int cnt = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++){
            S[i] = Long.parseLong(stringTokenizer.nextToken());
        }


        for (int i=0; i<N; i++) {
            long num = S[i];
            int k = 0;
            int l = N - 1;
            while (k < l) {
                if (S[k] + S[l] == num) {
                    if (k != i && l != i) {
                        cnt++;
                        break;
                    } else if (k == i) {
                        k++;
                    } else {
                        l--;
                    }
                } else if (S[k] + S[l] > num) {
                    l--;
                } else {
                    k++;
                }
            }
        }
        System.out.println(cnt);
        bufferedReader.close();
    }
}

//public class N8_좋은수 { // 투 포인터
//    public static void main(String[] args) throws Exception{
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        Integer N = Integer.parseInt(stringTokenizer.nextToken());
//        // .nextToken() 필요 없음. 당연하지. 공백으로 문자를 나눌 필요가 없으니까.
//        long [] S = new long[N+1];
//        // 길이 설정을 N+1이 아니라 N으로.. N을 넣으면 길이가 N인것!
//
//        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        for (int i=0; i<N; i++) {
//            S[i] = Integer.parseInt(stringTokenizer.nextToken());
//            // Integer.parseInt가 아니라 Long.parseLong
//            // Integer 범위:
//        }
//
//        // Arrays.sort(A); 정렬을 해줘야한다는 사실...!!!!
//
//        int cnt = 0;
//        for (int i=0; i<N; i++) {
//            // long num = S[i]; 찾는 값을 선언
//            int k = 0;
//            int l = N - 1;
//            // while (i < j) {
////                if(S[k] + S[l] == num) {
////                    if (i != k && i != l) {
////                        cnt++;
////                        break;
////                    }
////                    else if (i == k) { // ex) 0 1 2 3 4 5
////                        k++;
////                    }
////                    else if (i == l) {
////                        l--;
////                    }
////                }
////                else if (S[k] + S[l] > num){
////                    l--;
////                }
////                else{
////                    k++;
////                }
//            // }
//            if (S[i] < S[k] + S[l]) {
//                k++;
//            }
//            else if (S[i] > S[k] + S[l]) {
//                l--;
//            }
//            else {
//               cnt ++;
//               break;
//            }
//        }
//
//        System.out.println(cnt);
//    }
//}