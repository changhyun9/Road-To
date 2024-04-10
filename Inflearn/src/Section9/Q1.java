package Section9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    /**
     * 나의 구현방법
     * weight, height를 변수로 갖는 Person 클래스를 정의하고
     * list에 저장한다. 이후, 2중 for문을 돌려서 키와 몸무게가 모두 큰
     * 경우가 있으면 break를 한다. 그렇지 않고, 모든 반복문을 돌았을 때
     * flag가 true 즉, 본인보다 weight, height가 큰 경우가 없는 것이기
     * 때문에 정답 answer를 하나 증가시킴.
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

        for (int i = 0; i < n; i++) {
            Person tmp = list.get(i);
            Boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (tmp.height < list.get(j).height) {
                    if (tmp.weight < list.get(j).weight) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}

class Person{
    int weight;
    int height;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}
