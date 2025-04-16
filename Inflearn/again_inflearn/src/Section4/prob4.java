package Section4;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        String T = bf.readLine();


        HashMap<Character, Integer> goal = new HashMap<>();
        for (char ch : T.toCharArray()) {
            goal.put(ch, goal.getOrDefault(ch, 0) + 1);
        }
        int len = T.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;

        int lt = 0;
        for (int rt = 0; rt < S.length(); rt++) {
            map.put(S.charAt(rt), map.getOrDefault(S.charAt(rt), 0) + 1);
            if (rt - lt + 1 == len) {
                if(goal.equals(map)) answer++;
                if(map.get(S.charAt(lt)) ==1) map.remove(S.charAt(lt));
                else map.put(S.charAt(lt), map.get(S.charAt(lt))-1);
                lt++;
            }
        }

        System.out.println(answer);

    }
}
