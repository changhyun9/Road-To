package Section4;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String t = bf.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int lt = 0, cnt = 0, answer = 0;
        for (int rt = 0; rt < s.length(); rt++) {
            boolean flag = true;
            if (map.containsKey(s.charAt(rt))) {
                map.put(s.charAt(rt), map.get(s.charAt(rt))-1);
                cnt++;
            } else {
                while (lt <= rt) {
                    if (map.containsKey(s.charAt(lt))) {
                        map.put(s.charAt(lt), map.get(s.charAt(lt))+1);
                    }
                    lt++;

                }
                cnt = 0;
            }
            while (cnt > t.length()) {
                if (map.containsKey(s.charAt(lt))) {
                    map.put(s.charAt(lt), map.get(s.charAt(lt)) + 1);
                }
                lt++;
                cnt--;
            }
            for (char c : t.toCharArray()) {
                if (map.get(c) != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        // 강의 해설 equals() 메서드를 활용해서 map끼리, key, value 모두 같은지 비교
        // 그리고 미리 t.length()-1 까지 넣어놓고 삽입, 비교, 삭제를 해서 투포인터 알고리즘 구현

        HashMap<Character, Integer> bm = new HashMap<>();
        HashMap<Character, Integer> am = new HashMap<>();
        int answer2 = 0;
        for(char x : t.toCharArray()) bm.put(x, bm.getOrDefault(x, 0)+1);
        for(int i=0; i<t.length()-1; i++) am.put(s.charAt(i), am.getOrDefault(s.charAt(i),0)+1);
        int lt2=0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer2++;
            am.put(s.charAt(lt2), am.get(s.charAt(lt2)) - 1);
            if(am.get(s.charAt(lt2))==0) am.remove(s.charAt(lt2));
            lt2++;
        }

        System.out.println(answer);
        System.out.println("!!"+answer2);

    }
}
