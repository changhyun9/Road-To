package Section4;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : a.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : b.toCharArray()) {
            if (!map.containsKey(ch)) {
                answer = "NO";
                break;
            }
            else{
                if (map.get(ch) == 0) {
                    answer = "NO";
                    break;
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }

//        for (char key : map.keySet()) {
//            if (map.get(key) !=0) {
//                answer = "NO";
//                break;
//            }
//        }

        System.out.println(answer);

    }
}
