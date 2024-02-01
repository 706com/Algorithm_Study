package BOJ.fail;

//소요시간 : 40분(실패 : 구현실패)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16987_계란으로_계란치기 {
    static int N;
    static ArrayList<Egg> eggs;
    static int max = 0;
    static int[] output = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Egg egg = new Egg(i,S,W);
            eggs.add(egg);
        }

        dfs(0,0,0);
        System.out.println(max);
    }
    static void dfs(int start, int depth, int cnt){
        //마지막 계란
//        if(start==N-1){
//            System.out.println(count);
//            return;
//        }

        //끝까지 도달
        if(depth == N){
            max = Math.max(max,cnt);
            return;
        }
        //남은 계란 수가 1개나 0개 남았을때
        if(cnt >= N-1 || eggs.get(start).S <= 0){
            dfs(start,depth+1,cnt);
            return;
        }

        for(int i=0; i<N; i++){
            Egg pickEgg = eggs.get(depth);
            Egg nowEgg = eggs.get(i);
            //깨려고 하는 계란이 본인
            if(depth==i){
                continue;
            }
            //왼손에 든 계란이 이미 깨져있음
            if(pickEgg.S <= 0){
                continue;
            }
            //깨려고 하는 계란이 이미 깨져있음
            if(nowEgg.S <= 0){
                continue;
            }
            output[0] = depth;
            output[1] = i;

            //계란 서로 부딪히기
            pickEgg.S -= nowEgg.W;
            nowEgg.S -= pickEgg.W;

            //상태 확인
            if(pickEgg.S <= 0){
                cnt++;
            }
            if(nowEgg.S <= 0){
                cnt++;
            }
            System.out.println(Arrays.toString(output));
            dfs(i,depth+1,cnt);

            // 백트래킹 돌고나서 계란 복구하기
            pickEgg.S += nowEgg.W;
            nowEgg.S += pickEgg.W;
        }

    }
    static class Egg{
        int index;
        int S;
        int W;
        public Egg(int index, int s, int w) {
            this.index = index;
            S = s;
            W = w;
        }
    }
}
