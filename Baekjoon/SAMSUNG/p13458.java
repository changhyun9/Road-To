package SAMSUNG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class p13458 {
    /**
     * 나의 풀이방법
     * 모든 시험장에 대하여 응시생을 배열로 저장하고
     * 반복문을 사용하여 모든 시험장을 탐색
     * 각 시험장에 대하여 총감독은 1명만 들어갈 수 있으니가
     * B만큼 뺀 수강생들을 대상으로 로직을 진행
     * 각 시험장의 수강생들을 C로 나누고 나머지가 있으면 +1을 더해서 값을 저장
     * 이 과정을 N만큼 반복. 이때 answer의 자료형을 long형으로 해주어야 함.
     * 시험장의 개수가 최대 1,000,000이고 학생수도 시험장당 최대 1,000,000이므로 최악의 경우 백만 x 백만 = 1조이므로
     * int형으로는 담을 수 없음. <- 이거 생각 못해내서 고전함.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            arr.add(tmp);
        }
        int B = sc.nextInt();
        int C = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int tmp = arr.get(i) -B;
            if(tmp > 0 ){
                if (tmp % C > 0) {
                    answer += (tmp/ C + 1);
                } else {
                    answer += tmp / C;
                }
            }
        }
        answer += N;
        System.out.println(answer);
    }

    /**public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else{
                map.put(tmp, map.get(tmp) + 1);
            }
        }

        int B = sc.nextInt();
        int C = sc.nextInt();

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            int student = key - B;
            if(student > 0 ){
                if (student % C > 0) {
                    answer += (student / C + 1) * map.get(key);
                } else {
                    answer += (student / C) * map.get(key);
                }
            }
        }
        answer += N;
        System.out.println(answer);
    }**/
}