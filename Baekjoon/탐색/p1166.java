package 탐색;

import java.util.Scanner;

public class p1166 {
    /**
     * double 자료형을 연산하고, long 자료형으로 형변환하는 이유는
     * 박스가 1.0이고, 담는 상자가 2.4일 경우에 결국 길이가 2인 상자에 담는 것과 같기 때문에
     * 해당 문제에서 mid+1, mid-1이 아닌 mid 값으로 범위를 설정하는 것과
     * 무한 루프에 빠지지 않게 범위가 변경되지 않는 경우에 멈추는 것 -> 이 두가지가 주요한 키포인트였던 것 같다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        double start = 0.0;
        double end = Math.min(Math.min(l, w), h);
        double mid;

        while(start < end){
            mid = (start + end) / 2;
            if ((long)(l/mid) * (long)(w/mid) * (long)(h/mid) < n) {
                if(end == mid) break;
                end = mid;
            } else {
                if(start == mid) break;
                start = mid;
            }
        }
        System.out.print(start);
    }
}