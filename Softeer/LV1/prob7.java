package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob7 {
    /**
     * 문제명 : 위험한 효도
     * 나의 풀이 방법 : 거리가 a(뒤돌아있는시간)보다 많이 남아있으면 다음턴까지 a+b를 기다려야 함으로 a+b를 더해주고,
     * a(뒤돌아있는시간) 보다 d (거리)가 더 짧게 남아있으면, d 만큼 돌고, a<->b 체인지를 진행하고,
     * 뒤의 로직을 반복한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] split = input.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int answer =0;

        for(int i=0; i<2; i++){
            int d = Integer.parseInt(split[2]);
            while(d > 0){
                if(d <= a) {
                    answer += d;
                    d = 0;
                }
                else {
                    answer += (a+b);
                    d -= a;
                }
            }
            int temp = a;
            a = b;
            b = temp;
        }

        System.out.println(answer);
    }
}
