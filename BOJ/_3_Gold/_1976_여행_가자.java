package BOJ._3_Gold;

//[260102] 32분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_여행_가자 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //경로 초기화
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());

                switch(num){
                    case 0: // 연결 X
                        break;
                    case 1: //연결
                        union(i,j);
                        break;
                }
            }
        }

        // 가능 여부 판단
        int result = -1;
        boolean impossibleFlag = false;
        st = new StringTokenizer(br.readLine());
        result = parent[Integer.parseInt(st.nextToken())];

        for(int i=1; i<=M; i++){
            if(result != parent[Integer.parseInt(st.nextToken())]){
                impossibleFlag = true;
                break;
            }
        }
        if(impossibleFlag){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }

        if(parent[x] < parent[y]){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }

        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}
