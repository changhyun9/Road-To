package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob6 {
    /**
     * 문제명 : 연탄 배달의 시작
     * 나의 풀이 방법 : 처음에는 i-1과 i 차이를 구하고, 배열에 저장한 뒤 배열의 처음부터 끝까지 스캔하려고 했다.
     * 근데, 최대 차이가 1부터 1000000 이므로 배열의 크기가 초과될 것 이라고 판단하여 다른 로직으로 풀기로 결정.
     * 오름차순으로 정렬되어 있다는 가정하에 근접 배열 (i-1, i) 만이 가장 가까운 거리이기 때문에 매번 두 좌표간의
     * 거리를 구하고, 더 작은 값이 있으면 변경하고, 거리가 같으면 증가하는 식으로 문제를 해결하였음.
     */
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer =0;
        int dis = Integer.MAX_VALUE;
        String numbers = bf.readLine();
        String[] split = numbers.split(" ");

        for(int i=1; i<n;i++){
            int diff = Integer.parseInt(split[i]) - Integer.parseInt(split[i-1]);
            if(diff < dis){
                answer = 1;
                dis = diff;
            } else if (diff == dis){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
