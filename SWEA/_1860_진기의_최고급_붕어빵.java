package SWEA;

// 12분 소요
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
            // 사람 오는 순서대로 큐에 정렬
            //+가장 늦게오는 사람이 언제인지 담아둠
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
            //실제 흐른시간이 마지막 온 사람 기점까지만 알면됨
            while(time<=max){
                // 조리시간 되면 빵 생성
                if(makeTime==M){
                    bread+=K;
                    makeTime = 0;
                }
                //예약 손님 도착시간이 됐을때, 빵이 있는지 없는지 판별
                //->한명이라도 빵을 못먹으면 Impossible 후 종료
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