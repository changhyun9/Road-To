package Section4;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();

        // 강의해설 HashMap을 이용해서 key-value 형태로 값을 저장하고, 값을 사용

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (char key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
