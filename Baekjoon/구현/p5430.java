package 구현;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class p5430 {
    /**
     * 나의 구현방법
     * 처음엔 단순하게 입력받은 연산자를 list에 넣고, 하나씩 Collections으로 reverse 시킴 -> 시간초과
     * 두번째로는 R이 여러개 나와서 reverse가 반복되니까 R이 홀수개로 나온 경우에만 list에 추가시키고 Collections으로 reverse 시킴 -> 시간초과
     * 세번째로는 Collections reverse 빼고, Queue를 생성해서 index를 활용해서 뒤집혓을 경우 시작 인덱스만 변화시켜서 출력 -> 틀림, 그래도 시간초과는 해결
     * 근데 Queue로는 유연하게 앞,뒤 인덱스로 접근이 불가능 해서 Dequeue를 생성해서 네번째 시도함. -> 틀림
     * 다섯번째로 질문게시판보면서 반례를 해보는데 아무런 값이 없을때 ,(쉼표) 지우려고 하다보니 [(열린 대괄호) 삭제 이슈 발생.
     * 그래서 마지막에 Length가 2 이상인 경우에만 ,(쉼표) 지우는 로직으로 변경 -> 틀림
     * 처음에 n이 주워졌을 때, 0에서 D하면 error 출력이고, R은 정상 배열 즉, []를 출력해야함. -> 해당 예외 상황 추가해서 해결.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String next = sc.next();
            List<Character> list = new ArrayList<>();

            String temp = "";

            for (int j =0; j < next.length(); j++) {
                if (next.charAt(j) == 'R') {
                    temp += next.charAt(j);
                } else {
                    if (temp.length() % 2 != 0) {
                        list.add('R');
                    }
                    temp = "";
                    list.add(next.charAt(j));
                }
            }
            if (temp.length() % 2 != 0) {
                list.add('R');
            }


            int n = sc.nextInt();
            Deque<Integer> queue = new LinkedList<>();

            String input = sc.next();
            input = input.replace("[", "");
            input = input.replace("]", "");

            String[] inputs = input.split(",");

            if (n > 0) {
                for (String s : inputs) {
                    queue.offer(Integer.parseInt(s));
                }
                boolean flag = true;
                boolean reversed = true;
                for (Character ch : list) {
                    if (ch == 'R') {
                        if (reversed) {
                            reversed = false;
                        } else {
                            reversed = true;
                        }

                    } else {
                        if (queue.size() <= 0) {
                            flag = false;
                            break;
                        } else {
                            if (reversed) {
                                queue.removeFirst();
                            } else {
                                queue.removeLast();
                            }
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (flag) {
                    Object[] objects = queue.toArray();
                    sb.append("[");
                    if (!reversed) {
                        for (int k = queue.size() - 1; k >= 0; k--) {
                            sb.append(objects[k]+",");
                        }
                    } else {
                        for (int k = 0; k < queue.size(); k++) {
                            sb.append(objects[k]+",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append("]");
                    System.out.println(sb.toString());
                } else {
                    System.out.println("error");
                }
            } else {
                if (list.contains('D')) {
                    System.out.println("error");
                } else {
                    System.out.println("[]");
                }
            }


        }
    }
}
