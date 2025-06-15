package org.example;

//Problem 3
//
//The given ciphertext is encrypted by two steps:
//
//Step 1. Vigenere cipher with key length of 3 (The first letter of the vigenere cipher key is "T")
//Step 2. Shift cipher
//
//Find the plaintext and the key, and keys used for Vigenere cipher and the shift cipher.
//
//Ciphertext: YJZAGBATXHVAEVHCZXSOTAIXWZWS
//
//        (Hint: The 4th, 7th, 11th, 14th, and 22nd letters of the plaintext are the same!)


//Vigenere Key: TOY, Shift Key: 7
//PlainText: YOUALWAYSHAVEACCESSTOANSWERS
public class Problem_3 {
    public static String vigenereDecrypt(String cipherText, String vigenereKey) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherTextChar = cipherText.charAt(i);
            char keyChar = vigenereKey.charAt(i % vigenereKey.length());

            // Vigenere 해독 공식을 사용해 각 문자 복원
            char decodedChar = (char) ((cipherTextChar - keyChar + 26) % 26 + 'A');
            plainText.append(decodedChar);
        }

        return plainText.toString();
    }

    // Shift Cipher 해독 함수
    public static String shiftDecrypt(String cipherText, int shiftKey) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);

            // Shift Cipher 해독
            char decodedChar = (char) ((c - 'A' - shiftKey + 26) % 26 + 'A');
            plainText.append(decodedChar);
        }

        return plainText.toString();
    }

    // 주어진 힌트 조건을 확인하는 함수
    public static boolean checkHintCondition(String plainText) {
        // 힌트에서 주어진 위치의 문자가 동일한지 확인
        char fourthLetter = plainText.charAt(3);  // 4번째 문자 (0부터 시작하므로 index는 3)
        return plainText.charAt(6) == fourthLetter &&
                plainText.charAt(10) == fourthLetter &&
                plainText.charAt(13) == fourthLetter &&
                plainText.charAt(21) == fourthLetter;
    }

    public static void main(String[] args) {
        String cipherText = "YJZAGBATXHVAEVHCZXSOTAIXWZWS";

        // Step 1: Vigenere Cipher 해독 (첫 번째 키는 "T", 나머지 두 자리를 탐색)
        char firstKey = 'T';
        for (char secondKey = 'A'; secondKey <= 'Z'; secondKey++) {
            for (char thirdKey = 'A'; thirdKey <= 'Z'; thirdKey++) {
                String vigenereKey = "" + firstKey + secondKey + thirdKey;

                // Vigenere 암호 해독
                String intermediateText = vigenereDecrypt(cipherText, vigenereKey);

                // Step 2: Shift Cipher 해독 (모든 가능한 Shift 키를 탐색)
                for (int shiftKey = 0; shiftKey < 26; shiftKey++) {
                    String plainText = shiftDecrypt(intermediateText, shiftKey);

                    // 힌트 조건을 확인하고 일치하는 경우에만 출력
                    if (checkHintCondition(plainText)) {
                        System.out.println("Vigenere Key: " + vigenereKey + ", Shift Key: " + shiftKey);
                        System.out.println("Decrypted Text: " + plainText);
                        System.out.println();
                    }
                }
            }
        }
    }
}
