package org.example;

//Problem 1
//
//The given ciphertext is encrypted using a shift cipher.
//Find the plaintext and the key.
//
//Ciphertext: VDKBNLDSNBNLOTSDQRDBTQHSX

//Key: 1
//Plaintext: WELCOMETOCOMPUTERSECURITY

public class Problem_1 {
    public static void main(String args[]) {
        // String 선언 (- 리터럴: 객체 생성없이 값을 그대로 대입 - 생성자: String을 인스턴스화 할때 새로운 객체가 생성)
        // String 선언 시, ''가 아니라 ""로..!
        String cipherText = "VDKBNLDSNBNLOTSDQRDBTQHSX";
        int key;
        // 배열로 변환
        String[] cipherTextList = cipherText.split("");
        int[] cipherTextNum = new int[cipherTextList.length];

        for (int i=0; i<cipherTextList.length; i++) {
            cipherTextNum[i] = cipherTextList[i].charAt(0);
        }

        for (int i=1; i<=26; i++) {
            System.out.print(i + " ");
            for (int j=0; j<cipherTextNum.length; j++){
                if (cipherTextNum[j] == 90) { // Z일 경우
                    cipherTextNum[j] = 65;    // A로 순환
                } else {
                    cipherTextNum[j] = cipherTextNum[j] + 1;
                }
                cipherTextList[j] = Character.toString((char) cipherTextNum[j]);
                System.out.print(cipherTextList[j]);
            }
            System.out.println(' ');
        }

    }
}
