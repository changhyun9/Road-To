package 연결리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class p1406 {
    /**
     * 나의 풀이 방법 : 처음엔 LinkedList와 cur를 이용해서 문제를 풀었는데, 시간 초과가 발생.
     * 이후, addFirst, addLast, removeFirst, removeLast의 메서드를 이용해도 시간 초과가 발생.
     * 그래서 구글 검색이후, iterator를 도입해서 문제를 풀었는데도 시간 초과가 발생.
     * 그래서 Scanner 를 사용하지 않고, Buffer 기반의 I/O를 사용함으로써 시간초과가 발생하지 않고, 문제 해결
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> list = new LinkedList<>();

        String b[] = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());

        for (String sb : b) {
            list.add(sb);
        }

        ListIterator<String> iter = list.listIterator();

        while(iter.hasNext()) iter.next();


        for (int i = 0; i < n; i++) {
            String command[] = br.readLine().split(" ");

            if (command[0].equals("L")) {
                if(iter.hasPrevious()) iter.previous();

            } else if (command[0].equals("D")) {
                if(iter.hasNext()) iter.next();

            } else if (command[0].equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }

            } else {
                iter.add(command[1]);
            }

        }

        System.out.println(String.join("", list));

    }
}
