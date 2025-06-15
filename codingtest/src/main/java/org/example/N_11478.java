package org.example;

import java.util.*;
import java.io.*;

public class N_11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int size = s.length();
        HashSet<String> checkSet = new HashSet<>();
        for(int i=1; i<=size; i++) {
            for(int j=0; j<size-i+1; j++) {
                checkSet.add(s.substring(j, j+i));
            }
        }
        System.out.print(checkSet.size());
    }
}


