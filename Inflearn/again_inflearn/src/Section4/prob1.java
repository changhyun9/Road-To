package Section4;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        char answer = ' ';
        for (char ch : hashMap.keySet()) {
            if (max < hashMap.get(ch)) {
                max = hashMap.get(ch);
                answer = ch;
            }
        }
        System.out.println(answer);
    }
}
