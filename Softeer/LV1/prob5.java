package LV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob5 {
    /**
     * 문제명 : [한양대 HCPC 2023] Tren del Fin del Mundo
     * 나의 풀이 방법 : 가장 남쪽의 좌표를 찾는 것 이었으니, y좌표 값이 가장 작은 것을
     * 찾으면 되겠다고 생각. 그래서 입력되는 좌표들을 y값을 비교하여 작으면 좌표값을 저장
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int x =Integer.MAX_VALUE;
        int y =Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            String coord = bf.readLine();
            String[] split = coord.split(" ");
            if(Integer.parseInt(split[1]) < y){
                x= Integer.parseInt(split[0]);
                y=Integer.parseInt(split[1]);
            }
        }

        System.out.println(x + " " + y);
    }
}
