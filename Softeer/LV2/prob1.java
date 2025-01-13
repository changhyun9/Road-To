package LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class prob1 {
    /**
     * 문제명 : GPT식 숫자 비교
     * 나의 풀이 방법 : 처음엔 단순 구현 문제일 줄 알았는데, x,y 값이 나오는 것을 보고 Coord 객체와 정렬 문제임을 떠올림.
     * 그래서 Coord 객체를 생성하고, Comparable 인터페이스의 compareTo 메서드를 구현하는데 오름차순, 내림차순 정렬 방법이
     * 까먹어서 검색해서 풀었음. 또, List를 정렬하는 방법이 기억나지 않아 검색해서 품. 그리고 split 메서드를 사용할 때 .(온점)을
     * 인식 못하는 것을 몰라서 헤매다가 IDE에 넣어보니 안되는 걸 깨달았음.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Coord> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            String[] split = input.split("\\.");

            if (split.length == 1) {
                list.add(new Coord(Integer.parseInt(split[0]), -1));
            } else {
                list.add(new Coord(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
        }

        Collections.sort(list);

        for (Coord coord : list) {
            if (coord.y == -1) {
                System.out.println(coord.x);
            } else {
                System.out.println(coord.x + "." + coord.y);
            }
        }

    }
}

class Coord implements Comparable<Coord> {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Coord object) {
        if (this.x == object.x) {
            return this.y - object.y;
        } else {
            return this.x - object.x;
        }
    }
}
