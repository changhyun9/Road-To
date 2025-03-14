package Section4;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String vote = bf.readLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : vote.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for (Character ch : map.keySet()) {
            if (map.get(ch) > max) {
                max = map.get(ch);
                answer = ch;
            }
        }

        System.out.println(answer);
    }
}
