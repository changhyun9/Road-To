package Section5;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<Patient> queue = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int prior = Integer.parseInt(st.nextToken());
            queue.offer(new Patient(i, prior));
        }

        while (!queue.isEmpty()) {
            Patient tmp = queue.poll();
            for (Patient x : queue) {
                if (x.prior > tmp.prior) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if(tmp.id == m ) break;
            }
        }
        System.out.println(answer);
    }
}

class Patient {
    int id;
    int prior;

    public Patient(int id, int prior) {
        this.id = id;
        this.prior = prior;
    }
}