package Section4;

import java.util.HashMap;
import java.util.Scanner;

public class Q4 {
    /**
     * 내가 구현한 방법
     * 2개의 문자열을 통해 T만큼의 구간을 HashMap으로 정의한다
     * 이후, 두개의 HashMap이 같은지 판별하고, 같으면 answer 증가
     * 다르면 그냥 통과한다. 다음으로 두개의 포인터를 두어 구간 처음의 key-value는
     * 제거하거나 사이즈를 줄이고, 구간 마지막 값 다음 요소를 추가하거나 value를 증가시킨다
     * 해당 과정을 수행하고, 다시 두개의 HashMap이 같은지를 판별한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int answer = 0, lt = 0;
        for (int i = 0; i < T.length(); i++) {
            char c = S.charAt(i);
            char t = T.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            map2.put(t, map2.getOrDefault(t, 0) + 1);
        }

        for (int rt = T.length(); rt < S.length(); rt++) {
            if (map1.equals(map2)) {
                answer++;
            }
            map1.put(S.charAt(rt), map1.getOrDefault(S.charAt(rt), 0) + 1);
            if (map1.containsKey(S.charAt(lt))) {
                if (map1.get(S.charAt(lt)) > 1) {
                    map1.put(S.charAt(lt), map1.get(S.charAt(lt))-1);
                } else {
                    map1.remove(S.charAt(lt));
                }
            }
            lt++;
        }
        if(map1.equals(map2)) answer++;
        System.out.println(answer);
    }
}
