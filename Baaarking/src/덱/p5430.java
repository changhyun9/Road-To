package 덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p5430 {
    /**
     * 나의 풀이 방법 : Deque로 문제 풀이를 접근하였고, 간단한 세부로직 같은 경우에는 저번에 풀었던 것 참고해서 품.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder("");
            boolean flag = true;
            boolean error = false;
            String cmd = bf.readLine();
            LinkedList<String> deque = new LinkedList<>();
            List<Character> list = new ArrayList<>();
            int size = Integer.parseInt(bf.readLine());

            String input = bf.readLine();
            input = input.replace("[", "").replace("]", "");
            String[] numbers = input.split(",");

            for(String num :numbers){
                deque.offer(num);
            }

            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R'){
                    flag = !flag;
                }
                else{
                    if(deque.isEmpty() || size == 0){
                        error = true;
                        break;
                    } else {
                        if(flag){
                            deque.pollFirst();
                        } else{
                            deque.pollLast();
                        }
                    }
                }
            }

            if(error){
                bw.write("error\n");
            } else{
                if(!deque.isEmpty()){
                    sb.append("[");
                    while (!deque.isEmpty()) {
                        if (flag) {
                            sb.append(deque.pollFirst() + ",");
                        } else{
                            sb.append(deque.pollLast() + ",");
                        }
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("]");

                } else{
                    bw.write("[]");
                }
                bw.write(sb.toString() + "\n");

            }
        }

        bw.flush();
        bw.close();
    }
}
