package Section5;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;


        // 강의 해설 Queue 의 맨앞 환자가 뒤의 환자 보다 위험도가 높으면 치료하고, 아니면 맨뒤로 보낸다.
        // 그냥 이중 포문을 이용해서 비교
        Queue<Patient> queue = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(new Patient(i, Integer.parseInt(st.nextToken()))); // 환자의 접수 순서와 위험도를 매개변수로 객체 생성
        }

        while (!queue.isEmpty()) {
            Patient poll = queue.poll(); // 진료 대상 환자를 뽑음
            for (Patient p : queue) { // 이후, Queue 에 있는 환자들 모두를 비교
                if (poll.sick < p.sick) { // 뒤에 있는 환자가 위험도가 더 높으면
                    queue.offer(poll); // 다시 맨 뒤로
                    poll = null; // 진료 대상이었던 한자는 삭제
                    break; // 그리고 멈춤
                }
            }

            if (poll != null) { // 이번에 진료 대상 환자가 가장 위험도가 높으면
                answer++; // 진료 받은 환자 수 증가
                if (poll.idx == m) { // 진료받은 환자가 우리가 찾던 환자라면
                    System.out.println(answer);
                }
            }
        }
    }
}

class Patient {
    int idx;
    int sick;

    public Patient(int idx, int sick) {
        this.idx = idx;
        this.sick = sick;
    }
}
