package Section5;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<Patient> queue = new LinkedList();
        PriorityQueue<Integer> prior = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            queue.offer(new Patient(val, i));
            prior.offer(val);
        }

        while (!queue.isEmpty()) {
            Patient poll = queue.poll();
            if (!prior.isEmpty() && poll.val == prior.peek()) {
                prior.poll();
                if (poll.idx == k) {
                    answer++;
                    break;
                } else {
                    answer++;
                }
            } else {
                queue.offer(poll);
            }
        }

        System.out.println(answer);
    }

}

class Patient {
    int val;
    int idx;

    public Patient (int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
