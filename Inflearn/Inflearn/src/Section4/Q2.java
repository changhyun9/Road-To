package Section4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
    /**
     * 내가 구현한 방법
     * 두개의 문자열을 입력받고, Q1과 동일하게 HashMap에 있으면 value값을 증가해서
     * 다시 put하고, HashMap에 존재하지 않으면, 해당 문자를 Key로 1을 value로 해서
     * HashMap에 삽입한다. 이후, 두 HashMap의 KeySet를 받아서 List로 변환한 뒤
     * 정렬을 진행하고, 차례대로 대조를 해보았을 때 다르면 break를 하고, flag를 false로
     * 변경한다. 이 과정을 통과하고, 해당 key-list로 두개의 HashMap의 value들을
     * 추출해서 비교한다. 만약 이 과정에서 다른 값이 있으면 flag를 false로 변환하고,
     * break를 한다. 모든 과정에서 같은 값을 가지고 있다면 flag는 true가 되고, YES를 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        boolean flag = true;
        int len = str1.length();
        for (int i = 0; i < len; i++) {
            if (map1.containsKey(str1.charAt(i))) {
                Integer cnt = map1.get(str1.charAt(i));
                map1.put(str1.charAt(i), ++cnt);
            } else {
                map1.put(str1.charAt(i), 1);
            }
            if (map2.containsKey(str2.charAt(i))) {
                Integer cnt = map2.get(str2.charAt(i));
                map2.put(str2.charAt(i), ++cnt);
            } else {
                map2.put(str2.charAt(i), 1);
            }
        }

        List<Character> list1 = new ArrayList<>(map1.keySet());
        Collections.sort(list1);
        List<Character> list2 = new ArrayList<>(map2.keySet());
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                flag = false;
                break;
            }
        }
        for (Character ch : list1) {
            if (map1.get(ch) != map2.get(ch)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    /**
     * 두개의 문자열 중 하나를 기준으로 잡고 HashMap를 설정한다.
     * 이후, 다른 문자열을 탐색하면서 HashMap에 없거나, 있는데 value 값이 다르면
     * Anagram이 아닌 것이다. 항상 두 문자열의 길이가 같다는 조건이 있기 때문이다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        boolean flag = true;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : str1.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                flag = false;
                break;
            }
            map.put(x, map.get(x) - 1);
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }*/
}
