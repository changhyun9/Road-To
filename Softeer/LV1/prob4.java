package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob4 {
    /**
     * 문제명 : [한양대 HCPC 2023] 개표
     * 나의 풀이 방법 : 입력받은 숫자를 5로 나눈 횟수 만큼 ++++를 출력하고
     * 나머지를 |로 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            int number = Integer.parseInt(bf.readLine());
            for(int j=0; j<number/5; j++){
                System.out.print("++++ ");
            }
            number %=5;
            for(int k=0; k<number; k++){
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
