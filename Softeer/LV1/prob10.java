package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob10 {
    /**
     * 문제명 : 근무 시간
     * 나의 풀이 방법 : 이전에 풀었을 때에는 시 끼리 빼고, 분끼리 빼서 시작 시간의 분이 종료 시간의 분보다 클 경우
     * 변환하는 로직을 추가했어야 했는데, 이번에는 통일되게 분으로 모두 변환해서 값을 구했음.
     * 결과가 분으로 변환하기도 하고, 시와 분이 같이 있으면 변환해야하는 로직이 필요하다고 생각했음.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer =0;
        for(int i=0; i<5; i++){
            String input = bf.readLine();
            String[] split = input.split(" ");
            String[] start = split[0].split(":");
            String[] end = split[1].split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            answer += (endTime - startTime);
        }
        System.out.println(answer);
    }
}
