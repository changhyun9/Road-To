package Section2;

import java.util.Scanner;

public class Q5 {
    /**
     * 내가 구현한 방법
     * 처음에 이중 포문으로 단순 계산을 했는데 범위가 200_000이 넘어가니까
     * 시간 초과가 떴음. 그래서 돌면서 나눠지는 수가 있으면 바로 for문을 빠져나오는 식으로
     * 불필요한 횟수를 줄여주니까 성공, 또한 탐색 범위를 제곱근 으로 줄여주니 성공
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int answer = 0;
        for (int i = 2; i <= count; i++) {
            boolean isPrime = true;
            for(int j=2; j*j<=i; j++){
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        System.out.println(answer);
    }

    /**
     * 에라토스테네스 체를 이용한 방법
     * 2~N까지의 배열을 생성한 뒤, 배열의 값이 0 인것을 탐색함.
     * 그럼 해당 값은 소수임. 그리고 해당 소수의 배수들을 모두 체크해서 값을 1으로 변경
     * 의미는 배수이기 때문에 해당 소수를 약수로 가진다는 의미이고, 소수가 아니라는 것을 증명
     * 해당 방식으로 0인 것만 체크해서 소수의 개수를 구함
     *
     * 또 하나의 방법, 탐색 범위를 N의 제곱근까지만 탐색하는 것이다.
     * N이 소수가 아닌 합성수라고 가정해보자. 그렇다면, N = a * b라고 할 수 있다.
     * 이때 a,b는 2<= a <= b < N 이다. 여기서 a와 b가 N의 제곱급 보다 크다고 가정하면
     * a * b > N 이 되어 버리므로 N = a * b가 모순이 되어버린다. 따라서 a,b 중 적어도
     * 하나는 N의 제곱근 보다 작거나 같아야 한다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int answer = 0;
        int[] arr = new int[count + 1];
        for (int i = 2; i <= count; i++) {
            if(arr[i] == 0){
                answer++;
                for (int j = i; j <= count; j = j + i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }*/
}
