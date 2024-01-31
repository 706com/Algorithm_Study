package BOJ;

//소요시간 : 40분(실패 : 구현실패)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _16987_계란으로_계란치기 {
    static int N;
    static ArrayList<Egg> eggs;
    static int count = 0;

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

        dfs(0,0);
    }
    static void dfs(int start, int depth){
        //마지막 계란
        if(start==N-1){
            System.out.println(count);
            return;
        }
        for(int i=0; i<N; i++){
            Egg pickEgg = eggs.get(depth);
            //이미 계란 깨짐
            if(pickEgg.S<=0){
                continue;
            }
            //꺠려고 하는 계란이 이미 깨져있음
            if(eggs.get(i).S <= 0){
                continue;
            }
            //깨려고 하는 계란이 본인임
            if(pickEgg.index == i){
                continue;
            }
            eggs.get(i).S -= pickEgg.W;
            pickEgg.S -= eggs.get(i).W;
            if(eggs.get(i).S <= 0){
                count++;
            }
            if(pickEgg.S <= 0){
                count++;
            }
            dfs(i,depth+1);
            eggs.get(i).S += pickEgg.W;
            pickEgg.S += eggs.get(i).W;
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
