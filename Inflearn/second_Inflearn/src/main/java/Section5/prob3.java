package Section5;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        StringTokenizer st;
        List<Deque<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0)
                    map.get(j).offerLast(num);
            }
        }

        int m = Integer.parseInt(bf.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        for (int idx : moves) {
            idx = idx - 1;
            if (!(map.get(idx).isEmpty())) {
                Integer num = map.get(idx).pollFirst();
                if (stack.isEmpty()) {
                    stack.push(num);
                } else {
                    Integer top = stack.peek();
                    if (top == num) {
                        answer+=2;
                        stack.pop();
                    } else {
                        stack.push(num);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    // 강의 해설 이중 for문을 사용해서 문제해결
    public static void lecture(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] board = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(bf.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
