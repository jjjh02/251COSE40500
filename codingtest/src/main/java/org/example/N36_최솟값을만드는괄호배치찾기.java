package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 난 기호별로 나누려고 했는데 '-'로만 split 하면 됨
// '-' 앞에 있는 수들은 더하고, '-' 뒤에 있는 수들은 뺌

public class N36_최솟값을만드는괄호배치찾기 {
    static int answer = 0;
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for(int i=0; i<str.length; i++) {
            int tmp = mySum(str[i]);
            if (i==0)
                answer = answer + tmp;
            else
                answer = answer - tmp;
        }
        System.out.println(answer);

    }
    static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int i=0; i<temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }

}


//public class N36_최솟값을만드는괄호배치찾기 {
//    public static void main(String [] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String eqstr = bufferedReader.readLine();
//
//        StringTokenizer eqst = new StringTokenizer(eqstr, "-");
//        List<String> tokenList = new ArrayList<>();
//
//        while (eqst.hasMoreTokens()) {
//            tokenList.add(eqst.nextToken().trim());
//        }
//
//        for (int i=0; i<tokenList.)
//
//    }
//
//    static int sumofgroup(String str) {
//        int sum = 0;
//        StringTokenizer num = new StringTokenizer(str, "+");
//        while(num.hasMoreTokens()){
//            sum = sum + Integer.parseInt(num.nextToken());
//        }
//
//        return sum;
//    }
//
//}
