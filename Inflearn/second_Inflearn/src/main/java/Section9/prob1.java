package Section9;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Person[] arr = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            arr[i] = new Person(a,b);
        }

        Arrays.sort(arr);

        // 강의 해설 키, 몸무게 중 하나를 기준으로 잡아서 내림차순 정렬
        // 이후, 지원자는 다른 사람보다 키, 몸뭄게 모두 커야하기 때문에 이전의 최대 값보다 현재의 값이 커야한다.
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (Person ob : arr) {
            if (max < ob.w) {
                cnt++;
                max = ob.w;
            }
        }


        System.out.println(cnt);
    }



}

class Person implements Comparable<Person>{
    int h;
    int w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    public int compareTo(Person o) {
        return o.h-this.h;
    }
}
