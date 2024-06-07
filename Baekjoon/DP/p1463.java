package DP;

import java.util.Scanner;

public class p1463 {

    static Integer[] mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mem = new Integer[n+1];
        mem[0]=mem[1]=0;
        System.out.println(dp(n));
    }
    static int dp(int n){
        if (mem[n] == null) {
            if (n % 6 == 0) {
                mem[n] = Math.min(dp(n - 1), Math.min(dp(n / 3), dp(n / 2))) + 1;
            } else if (n % 3 == 0) {
                mem[n] = Math.min(dp(n / 3), dp(n - 1)) + 1;
            } else if (n % 2 == 0) {
                mem[n] = Math.min(dp(n / 2), dp(n - 1)) + 1;
            } else {
                mem[n] = dp(n - 1) + 1;
            }
        }
        return mem[n];
    }
}