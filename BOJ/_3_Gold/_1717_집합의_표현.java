package BOJ._3_Gold;

//[260101] 🔍

import java.util.*;
import java.io.*;

public class _1717_집합의_표현 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        // 초기화 진행 = 본인이 곧 부모
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(command){
                case 0:
                    union(a,b);
                    break;
                case 1:
                    boolean isSame = isSameSet(a,b);
                    if(isSame){
                        sb.append("YES").append("\n");
                    } else{
                        sb.append("NO").append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

    // 유니온시 부모 선정 기준 : 둘 중 작은값
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }

        if(x < y){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }
    // 부모 찾기
    // return 후에 본인을 부모로 업데이트 작업 필수
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int root = find(parent[x]); // 1. x의 최종 부모(루트)를 찾고
        parent[x] = root;           // 2. x의 부모를 그 루트로 갱신 (경로 압축)
        return root;                // 3. 루트를 반환
    }
    public static boolean isSameSet(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return true;
        }
        return false;
    }
}
