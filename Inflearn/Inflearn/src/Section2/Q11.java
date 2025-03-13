package Section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11 {
    /**
     * 내가 구현한 방법
     * 그동안 경험했던 반을 저장하고, 학생 수에 맞게 ArrayList를 저장하는
     * list를 선언한다. 이후 삼중 for문을 같은 열에서 같은 값을 가진 학생의
     * list에 값을 추가한다. 이때, 기존에 만났던 학생이라면 추가하지 않는다.
     * 이렇게 모든 학생을 검사한뒤, 가장 큰 list의 size를 구해서 해당
     * list의 인덱스를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int[][] ban = new int[people][5];

        for (int i = 0; i < people; i++) {
            for (int j = 0; j < 5; j++) {
                ban[i][j] = sc.nextInt();
            }
        }
        List<ArrayList<Integer>> friendShip = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            friendShip.add(new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < people; j++) {
                for(int k=j+1; k<people; k++){
                    if(ban[j][i] == ban[k][i]){
                        if (!friendShip.get(j).contains(k)){
                            friendShip.get(j).add(k);
                            friendShip.get(k).add(j);
                        }
                    }
                }
            }
        }
        int max = 0;
        int index = 0;
        for (ArrayList<Integer> list : friendShip) {
            if (max < list.size()) {
                max = list.size();
                index = friendShip.indexOf(list);
            }
        }
        System.out.println(index+1);
    }

    /**
     * 나는 하나의 열을 기준으로 중복되는 값을 구했다. 즉 같은 학년에서
     * 같은 반을 구했지만, 강의에서는 하나의 행을 기준으로 값을 구했다.
     * 그러면서 1번 학생과 2번 학생이 2학년때 같은 반이고 3학년때 같은 반이라고
     * 할 때 중복되는 카운트 값을 제거하기 위해서 한번 같은 반 이었던 학생은 다음 탐색을
     * 하지 않고 반복문을 빠져나온다. 그래서 같은 반을 한 친구가 가장 많은 학생을 구할 수 있다
     * 또한, 0 인덱스를 사용하지 않기 위해 배열의 사이즈를 하나씩 증가시켜 2차원 배열을 생성했다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] ban = new int[N+1][6];

        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=5; j++) {
                ban[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int cnt =0;
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= 5; k++) {
                    if(ban[i][k] == ban[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt){
                max = cnt;
                answer = i;
            }
        }
        System.out.println(answer);
    }*/
}
