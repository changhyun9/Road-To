package Section1;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int maxIndex = 0;
        String[] array = line.split(" ");
        for (int i = 0; i < array.length; i++) {
            if(array[maxIndex].length() < array[i].length()){
                maxIndex = i;
            }
        }
        System.out.println(array[maxIndex]);
    }
}
