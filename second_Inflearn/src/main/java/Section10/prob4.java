package Section10;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[n];
        int answer = 0;
        List<Block> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Block(s, h, w));
        }

        Collections.sort(list); // 높이를 기준으로 내림차순 정렬, 총 2개의 정렬 조건를 1개의 정렬 조건으로 줄이는 작업

        dp[0] = list.get(0).h; // 처음 벽돌을 맨 위에 쌓는 경우
        answer = dp[0];

        for (int i = 1; i < n; i++) { // 해당 인덱스의 벽돌을 맨 위에 쌓는 작업
            int max_h=0;
            for (int j = i - 1; j >= -0; j--) { // 인덱스 기준으로 앞에 있는 것들중 본인 밑에 올 수 있는 것들을 찾음.
                if (list.get(j).w > list.get(i).w && dp[j] > max_h) { // 길이는 정렬되어있으므로, 본인보다 무게가 높은 것들 중 최대 높이
                    max_h = dp[j]; // 본인이 맨 위로 올라간다고 했을 때, 밑에 쌓을 수 있는 최대 높이 저장
                }
            }
            dp[i] = max_h + list.get(i).h; // 본인이 맨 위에 있을 때, 가장 높은 경우
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }
}

class Block implements Comparable<Block> {
    int s;
    int h;
    int w;

    public Block(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    public int compareTo(Block ob) {
        return ob.s - this.s;
    }
}
