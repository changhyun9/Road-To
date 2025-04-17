package Section5;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0) list.get(j).add(num);
            }
        }

        int k = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = list.get(num);
            if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (!stack.isEmpty() && stack.peek() == poll) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(poll);
                }
            }
        }

        System.out.println(answer*2);
    }
}
