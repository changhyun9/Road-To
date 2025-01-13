package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob8 {
    /**
     * 문제명 : 나무 심기
     * 나의 풀이 방법 : n이 100 이하의 값이어서 n^2을 해도 최악의 경우 10000이기 때문에 이중 포문
     * 일일이 곱해보는 방식을 채택.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        String input = bf.readLine();
        String[] split = input.split(" ");
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                max = Math.max(arr[i]*arr[j], max);
            }
        }
        System.out.println(max);
    }
}
