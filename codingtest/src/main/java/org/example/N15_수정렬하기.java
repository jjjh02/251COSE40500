package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N15_수정렬하기 {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int [] nums = new int[N];

        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i=0; i<N-1; i++) {
            for (int j=0; j<N-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int i=-0; i<N; i++) {
            System.out.println(nums[i]);
        }
    }
}

//public class N15_수정렬하기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(bufferedReader.readLine()); // 공백이 없으면 그냥 buffferReader로 받아오면 됨
//        int[] nums = new int[N];
//        int temp;
//
//        for (int i=0; i<N; i++){
//            nums[i] = Integer.parseInt(bufferedReader.readLine()); // 여기서도
//        }
//        for (int i=0; i<N-1; i++){
//            for (int j=0; j<N-1-i; j++){
//                if(nums[j] > nums[j+1]){
//                    temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }
//        for (int i=0; i<N; i++){
//            System.out.println(nums[i]);
//        }
//    }
//}
