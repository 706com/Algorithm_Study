package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1860_진기의_최고급_붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int max = 0;
            //최대 시간 계산
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
                max=  Math.max(max,num);
            }

            int bread = 0;
            int time = 0;
            int makeTime = 0;
            boolean check = true;
            //현재 시간이 오는사람 최대까지만 반복 돌리기
            while(time<=max){
                // 조리시간 되면 빵 생성
                if(makeTime==M){
                    bread+=K;
                    makeTime = 0;
                }
                // 손님 도착시간이 됐을 때, 빵 여부 판단
                if(pq.peek() <= time){
                    if (bread <= 0) {
                        check = false;
                        break;
                    } else {
                        pq.poll();
                        bread--;
                    }
                }
                time++;
                makeTime++;
            }
            if(!check){
                System.out.printf("#%d Impossible\n",count);
            }
            else{
                System.out.printf("#%d Possible\n",count);
            }
            count++;
        }
    }
}