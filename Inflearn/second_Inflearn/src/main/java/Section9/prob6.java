package Section9;

import java.io.*;
import java.util.*;

public class prob6 {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for(int i=1;i<=n; i++)unf[i] = i; // 초기는 인덱스 번호 자기자신으로 집합 번호를 초기화한다.

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b); // a,b를 같은 집합으로 초기화
        }

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa =find(a);
        int fb = find(b);

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void union(int a, int b) {
        int fa = find(a); // a가 어느 집합에 속해있는지 확인
        int fb = find(b); // b가 어느 집합에 속해있는지 확인
        if(fa != fb) unf[fa] = fb; // 만약 같은 집합에 속해있지 않으면 같은 집합으로 변경
    }

    static int find(int v){
        if(v == unf[v]) return v; // 본인 인덱스와 집합 번호가 같으면 인덱스 번호 리턴
        else return unf[v] = find(unf[v]); // 경로를 압축하며, 본인이 속한 집합 번호의 부모 노드를 찾아서 올라감.
    }
}
