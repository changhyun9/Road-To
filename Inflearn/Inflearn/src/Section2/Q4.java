package Section2;

import java.util.Scanner;

public class Q4 {
    /**
     * 내가 구현한 방법
     * 입력값이 3부터 시작이기 때문에 미리 f(1), f(2) 값을
     * 초기화 하고, 반복문을 인덱스 3부터 시작해서 앞 두개의
     * 값을 더해서 저장
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        array[0] =1;
        array[1] = 1;
        for(int i =2; i<size;i++){
            array[i] = array[i-2]+array[i-1];
        }
        for (int one : array) {
            System.out.print(one+" ");
        }
    }

    /**
     * 배열을 사용하지 않는 방법
     * 3개의 변수를 이용해서 값을 구한 뒤,
     * 다음 값을 구하기 위해 값을 옮기는 형태
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int a=1;
        int b=1;
        int c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < count; i++) {
            c = a+b;
            System.out.print(c+ " ");
            a = b;
            b = c;
        }
    }*/
}
