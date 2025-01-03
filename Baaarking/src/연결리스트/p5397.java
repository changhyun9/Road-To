package 연결리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class p5397 {
    /**
     * 나의 풀이 방법 : 이전에 강의 연습문제로 풀었던 '에디터'와 같은 로직으로 풀었다. 이번엔 Scanner를 사용하지 않고,
     * BufferedReader를 사용해서 입력을 받았다. 근데 처음엔 LinkedList의 제네릭스를 Character로 해서
     * 마지막 출력 과정에서 for문을 돌리다보니, 시간초과가 발생했다. 그래서 LinkedList의 제네릭스를 String으로 하고
     * LinkedList에 값이 들어갈 때만, character + ""으로 String 형변환을 진행해서 집어넣었고, 마지막 출력은
     * String.join() 메서드를 이용해서 출력해줌.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            LinkedList<String> list = new LinkedList<>();
            ListIterator<String> iter = list.listIterator(); // cursor 역할

            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == '<') {
                    if(iter.hasPrevious()) iter.previous();

                } else if (ch == '>') {
                    if(iter.hasNext()) iter.next();

                } else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(ch+"");
                }
            }
            System.out.println(String.join("",list));

        }
    }
}
