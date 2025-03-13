package Section4;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        HashMap<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        int lt = 0, cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            cnt++;
            if (cnt == k) {
                System.out.print(map.size() + " ");
                if (map.get(arr[lt]) == 1) {
                    map.remove(arr[lt]);
                } else {
                    map.put(arr[lt], map.get(arr[lt]) - 1);
                }
                lt++;
                cnt--;
            }
        }

        // 강의 해설 미리 k-1를 HashMap에 넣어놓고, for을 k-1부터 시작
        // 그러면 바로 k-1번째를 넣으면 k만큼 들어가기 때문에 cnt변수와 cnt == k 를 확인하는 로직이 필요 없음.
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt2 = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            System.out.print(map.size()+ " ");
            map.put(arr[lt2], map.get(arr[lt2]) - 1);
            if(map.get(arr[lt2])==0) map.remove(arr[lt2]);
            lt2++;
        }

    }
}
