package Section6;

import java.util.Scanner;

public class Q4 {
    /**
     * 나의 구현한 방법
     * List로 캐시 만들어 놓고
     * S -> 캐시 사이즈보다 작을때
     *      1. 없는 경우, 그냥 뒤에 삽입
     *      2. 있는 경우, 제거하고 다시 삽입?
     * S -> 캐시 사이즈랑 같을 때
     *      1. 없는 경우, 맨앞 작업을 제거하고, 새로운 값 삽입
     *      2. 있는 경우, 제거하고 다시 삽입?
     * 해당 방법으로 진행하니 RuntimeError 남
     *
     * 강의 구현법
     * cache에 현재 작업이 포함되어 있는지 확인하고 cache miss 인지, cache hit 인지 확인함
     * cache miss 라면, 캐시 마지막 인덱스 부터 바로 앞의 인덱스와 swap함. size -1 부터 1까지 진행
     * cache hit 라면, 현재 작업이 있는 인덱스부터 1번 인덱스 까지 swap함.
     * 이후 가장 최근 작업을 알리는 0번 인덱스에 작업값을 삽입함.
     */
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int size = sc.nextInt();
       int c = sc.nextInt();
       int[] work = new int[c];
       int[] cache = new int[size];

       for (int i = 0; i < c; i++) {
           work[i] = sc.nextInt();
       }

       for (int x : work) {
           int pos = -1;
           for(int i=0; i<size; i++) if(x == cache[i]) pos = i;
           if (pos == -1) {
               for (int j = size - 1; j >= 1; j--) {
                   cache[j] = cache[j - 1];
               }
           } else {
               for (int j = pos; j >= 1; j--) {
                   cache[j] = cache[j - 1];
               }
           }
           cache[0] = x;
       }

       for (int i : cache) {
           System.out.print(i +" ");
       }
   }
}
