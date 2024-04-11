package Section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    /**
     * 나의 구현방법
     * weight, height를 변수로 갖는 Person 클래스를 정의하고
     * list에 저장한다. 이후, 2중 for문을 돌려서 키와 몸무게가 모두 큰
     * 경우가 있으면 break를 한다. 그렇지 않고, 모든 반복문을 돌았을 때
     * flag가 true 즉, 본인보다 weight, height가 큰 경우가 없는 것이기
     * 때문에 정답 answer를 하나 증가시킴. -> 최악의 경우가 30,000이기 때문에 시간초과가 발생함.
     * 근데 강의 채점에는 제공을 안했기 때문에 정답인줄 알고 넘어갔음. 그래서 작성 내용은 다 지우고
     * 강의 내용으로 코딩 다시 진행
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Person(height, weight));
        }

        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for (Person p : list) {
            if (p.weight > max) {
                max = p.weight;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

class Person implements Comparable<Person>{
    int weight;
    int height;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        return person.height - this.height;
    }
}
