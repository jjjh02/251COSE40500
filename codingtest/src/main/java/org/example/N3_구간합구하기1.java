package org.example;

// 1번 방법
//for i = 0 ~ M :
//    k = input()
//    l = input()
//    for j = k ~ l :
//    result[i] += arr[j]
//
//for i = 0 ~ M:
//    print(result[i])
// --> M*N + M = 10^10+10^5
// 연산 횟수는 1초에 1억 번 연산하는 것을 기준으로 생각 (100초)

// 2번 방법
//sum[0] = arr[0]
//for i = 1 ~ N :
//    sum[i] = sum[i-1] + arr[i]
//for i = 0 ~ M :
//    k = input()
//    l = input()
//    // l - (k-1)
//    result[i] = sum[l] - sum[k-1]
// N+M = 2*10^5


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BufferedReader
// : 입력 스트림에서 문자를 읽는 함수 (버퍼링 기능 추가 - 문자들을 버퍼에 저장하고 읽는 방법)
// - 버퍼의 사이즈 지정 가능
// - 라인 단위로 경계를 인식 => 공백의 경우도 string으로 인식
// - 입력받은 데이터 타입이 string 타입, 형변환 필요
// Scanner와의 차이 : 속도 (Scanner의 버퍼 사이즈는 매우 작아 입력과 동시에 즉시 전달)

// StringTokenizer
// : 특정 문자열을 구분자를 지정해 분리할 때 사용되는 클래스
// - StringTokenizer(br.readLine()); 라인 단위, nextToken(); 특정 문자열 단위 가능
// - 반드시 throws IOException, 형변환
// - 특정 문자열 단위로 읽고 싶을 때는 new StringTokenizer(st.nextToken(), 특정문자열)) 뒤에 인자를 추가


public class N3_구간합구하기1 { // 구간 합
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Integer N = Integer.parseInt(stringTokenizer.nextToken());
        Integer M = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[N+1]; // 여기서 길이 설정을 N+1로 하는 이유: line59 때문에

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i=1; i<N; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i=0; i<M; i++) {
            Integer startNum = Integer.parseInt(stringTokenizer.nextToken());
            Integer endNum = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[endNum]-S[startNum-1]);
        }


    }
}