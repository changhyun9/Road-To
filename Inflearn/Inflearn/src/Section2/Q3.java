package Section2;

import java.util.Scanner;

public class Q3 {
    /**
     * 내가 구현한 방법
     * 반복문을 이용해서 A,B를 초기화하고
     * 반복문을 이용해서 같은 인덱스끼리 값을 비교한다
     * A를 기준으로 1,2,3 경우를 나누고 또, 각각 경우에서 B가 1,2,3인
     * 경우를 체크해서 승부를 결정한다. 총 9가지 경우의 수를 판단한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] A = new int[count];
        int[] B = new int[count];

        for (int i = 0; i < count; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < count; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < count; i++) {
            if(A[i] == 1){
                if(B[i] == 1){
                    System.out.println("D");
                } else if (B[i] == 2) {
                    System.out.println("B");
                }
                else {
                    System.out.println("A");
                }
            } else if(A[i] == 2){
                if(B[i] == 1){
                    System.out.println("A");
                } else if (B[i] == 2) {
                    System.out.println("D");
                }
                else {
                    System.out.println("B");
                }
            } else{
                if(B[i] == 1){
                    System.out.println("B");
                } else if (B[i] == 2) {
                    System.out.println("A");
                } else {
                    System.out.println("D");
                }
            }
        }
    }

    /**
     * 기준을 하나 정해서, 이기는 상황과 비기는 상황을 체크하고
     * 나머지는 모두 지는 상황이기 때문에 경우의 수를 단순화 함
     * 모든 상황을 전부 체크하는 것이 아니라 기준을 잡고
     * 최소한으로 체크하고, 나머지는 하나로 퉁침
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] A = new int[count];
        int[] B = new int[count];

        for(int i =0; i<count; i++){
            A[i] = sc.nextInt();
        }
        for(int i =0; i<count; i++){
            B[i] = sc.nextInt();
        }

        for(int i=0; i<count; i++){
            if (A[i] == B[i]) {
                System.out.println("D");
            } else if (A[i] == 1&& B[i] ==3) {
                System.out.println("A");
            } else if (A[i] == 2 && B[i] == 1) {
                System.out.println("A");
            } else if (A[i]==3 && B[i] == 2) {
                System.out.println("A");
            } else{
                System.out.println("B");
            }
        }
    }*/
}
