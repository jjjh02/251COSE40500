package org.example;

//Problem 2
//
//The given ciphertext is encrypted using a Vigenere cipher.
//Find the plaintext and the key. (The key length is 3)
//
//Ciphertext: FFJFSFPYRUSBZLCFMFBIEIMFFZR
//
//        (Hint: the plaintext starts with 'A') -> the key starts with 'F'

// m: key의 길이, i: ciphertext의 길이
// {C_i - k_(i mod m)} mod 26

//PlainText: ALWAYSKEEPYOURPASSWORDSSAFE
//Key: FUN

// m: 3, i: 27
// {C_i - k_(i mod m)} mod 26


// 각 ciphertext char에서 key[i%3]를 빼서 나타냄

// decode 함수 > ciphertext 중 하나의 char에서 key 하나의 char만큼을 빼는 걸 ciphertext.length만큼 반복하는 함수
// main 함수 > key[0]은 고정이지만 key[1], key[2]를 위해 A~Z 반복,


public class Problem_2 {

    public static String decode(String cipherText, String key) {
        // 우선 Stringbuilder란 무엇인지 ..
        // 가변적으로 계속 append 되어야한다는 점에서 StringBuilder 사용
        StringBuilder decodedText = new StringBuilder();

        // for 문에 인수가 2개인 점
        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            // String으로 받아온 cipherText를 char로 접근해서 charAt으로 나눈 점
            // String class의 method 중 하나로 string의 한 부분을 char로 변환
            char c = cipherText.charAt(i);

            // 이 식 자체를 썼다는 점 ..  한번 다시 보기
            //
            char decodedChar = (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            // append로 decodedChar를 decodedText에 추가한 점
            decodedText.append(decodedChar);

            // j 식은 이 안에 있다는 점
            j = (j + 1) % key.length();
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        String cipherText = "FFJFSFPYRUSBZLCFMFBIEIMFFZR";

        // 첫 번째 키 문자는 F로 고정
        char firstKey = 'F';

        // 문자로 루프를 접근했다는 점
        for (char secondKey = 'A'; secondKey <= 'Z'; secondKey++) {
            for (char thirdKey = 'A'; thirdKey <= 'Z'; thirdKey++) {
                // key를 이런식으로 연결도 가능하다는 점
                String key = "" + firstKey + secondKey + thirdKey;

                String decodedText = decode(cipherText, key);

                System.out.print(key + " ");
                System.out.println(decodedText);
            }
        }
    }
}

