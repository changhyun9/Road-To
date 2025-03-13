package Section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q8 {
    /**
     * 내가 구현한 방법
     * 못풀어서, 강의들음.
     * id, priority를 가진 클래스를 새롭게 선언
     * Queue안에서 본인보다 뒤에 우선순위가 큰 값이 있는지
     * 확인. 있으면 뒤로 값을 이동시키고, 본인이 가장 큰 값이면
     * Queue에서 poll함. 이때, poll된 객체가 M인지 확인.
     * 동일하면, 연산을 종료하고, 그렇지 않으면 결과값을 증가하고
     * 계속해서 연산 진행
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        int[] array = new int[N];
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            queue.offer(new Patient(i, array[i]));
        }

        while (!queue.isEmpty()) {
            boolean biggest = true;
            Patient patient = queue.poll();
            for (Patient p : queue) {
                if (p.priority > patient.priority) {
                    queue.offer(patient);
                    biggest = false;
                    break;
                }
            }
            if (biggest) {
                answer++;
                if (patient.id == M) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

class Patient {
    int id;
    int priority;

    public Patient(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
