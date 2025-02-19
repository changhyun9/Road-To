package 스택의활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2504 {
    /**
     * 나의 풀이 방법 :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        Stack<String> stack = new Stack<>();
        boolean flag = true;
        int answer =0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                stack.push(input.charAt(i)+"");
            }
            else {
                if(input.charAt(i) == ')'){
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.push(2 + "");
                        } else if (stack.isEmpty() && isDigit(stack.peek())) {
                            int pop;
                            while (true) {
                                pop = Integer.parseInt(stack.pop());
                                if (!isDigit(stack.peek())) {
                                    if (stack.peek().equals("(")) {
                                        stack.pop();
                                        stack.push(pop * 2 + "");
                                        break;
                                    } else if (stack.peek().equals("[")) {
                                        flag = false;
                                        break;
                                    }
                                } else {
                                    int num = Integer.parseInt(stack.pop());
                                    stack.push(pop + num + "");
                                }
                            }

                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }

                } else if (input.charAt(i) == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            stack.push(3+"");
                        } else if (isDigit(stack.peek())) {
                            int pop;
                            while (true) {
                                pop = Integer.parseInt(stack.pop());
                                if (stack.isEmpty() && !isDigit(stack.peek())) {
                                    if (stack.peek().equals("[")) {
                                        stack.pop();
                                        stack.push(pop * 3 + "");
                                        break;
                                    } else if (stack.peek().equals("(")) {
                                        flag = false;
                                        break;
                                    }
                                } else {
                                    int num = Integer.parseInt(stack.pop());
                                    stack.push(pop + num + "");
                                }
                            }
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }

                }

            }
        }

        if (flag) {
            if (!stack.isEmpty()) {
                for (String ch : stack) {
                    if (!isDigit(ch)) {
                        System.out.println("0");
                        break;
                    } else {
                        answer += Integer.parseInt(ch);
                    }
                }
            } else {
                System.out.println("0");
            }

        } else{
            System.out.println("0");
        }

        if(flag) System.out.println(answer);


    }

    public static boolean isDigit(String num) {
        try {
            int temp = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
