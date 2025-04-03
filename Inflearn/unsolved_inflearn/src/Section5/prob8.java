package Section5;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Patient> queue = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int dangerous = Integer.parseInt(st.nextToken());
            queue.offer(new Patient(i,dangerous));
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Patient poll = queue.poll();
            for (Patient p : queue) {
                if (p.priority > poll.priority) {
                    queue.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                answer++;
                if(poll.id == m) break;
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
