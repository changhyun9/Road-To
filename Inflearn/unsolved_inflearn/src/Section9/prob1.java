package Section9;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 1;

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            people[i] = new Person(height, weight);
        }

        Arrays.sort(people);

        for (int i = 0; i < n-1; i++) {
            int max = people[i].weight;
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if(people[j].weight > max){
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }

        System.out.println(answer);
    }
}

class Person implements Comparable<Person> {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Person obj) {
        return this.height - obj.height;
    }
}