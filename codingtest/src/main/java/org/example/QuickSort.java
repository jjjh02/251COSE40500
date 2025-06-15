package org.example;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return; // 종료

        int pivot = partition(arr, left, right); // 피벗 기준으로 분할
        quickSort(arr, left, pivot - 1);  // 왼쪽 부분 정렬
        quickSort(arr, pivot + 1, right); // 오른쪽 부분 정렬
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // pivot - 마지막 요소
        int i = left - 1; // 왼쪽(작은쪽) 요소 인덱스

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) { // pivot보다 작은 값
                i++;
                swap(arr, i, j); // i(왼쪽 인덱스) <-> j(원래 요소 인덱스)
            }
        }
        swap(arr, i + 1, right); // 피벗을 올바른 위치로 이동 - i+1(왼쪽이 끝나는 인덱스) <-> right(pivot 인덱스)
        return i + 1; // 새로운 pivot 위치
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}