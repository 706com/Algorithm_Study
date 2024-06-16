package BOJ._3_Gold;

//소요시간
//[240617] : 20분

import java.io.*;
import java.util.*;

public class _11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[V+1][V+1];
        for(int i=1; i<map.length; i++){
            Arrays.fill(map[i],10000000);
            map[i][i] = 0;
        }
        //맵 생성
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end],cost);
        }

//        //출력
//        for(int i=1; i<=V; i++){
//            for(int j=1; j<=V; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        //경로 최신화
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                for(int k=1; k<=V; k++){
                    if(map[j][k] == 0){
                        continue;
                    }
                    // 기존에 있던 값이랑, 반드시 한 번 찍고 가는 경로의 합 구하기
                    map[j][k] = Math.min(map[j][k] , map[j][i]+map[i][k]);
                }
            }
        }

        System.out.println();
        //출력
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(map[i][j] == 10000000){
                    map[i][j] = 0;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
