package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;

// < 풀이 접근 >
// 1. 우선순위큐를 선언해서 오름차순 정렬시킨다.
// 2. 정렬시킬때 가장 늦게 오는 사람의 시간이 언제인지 저장시킨다.
// 3. 가장 늦게오는 사람의 시간까지 for문을 돌린다.
// 4. 빵 생성시기 : 현재시간 % M == 0 ( 1%2 도 0이니 예외처리 필요 )
// 5. Impossible 조건 :
//      1) pq 안에 들어있는 해당사람 시간이 되었는데 빵이 없을때.
//      2) do-while (해당시간에 줄 서있는 사람 모두한테 빵 주기) 을 거쳤을때 빵이 음수일 때


public class _1860_진기의_최고급_붕어빵 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            // 1. 우선순위큐를 선언해서 오름차순 정렬시킨다.
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int bread = 0;
            boolean possible = true;
            int max = 0;
            String result;

            // 2. 정렬시킬때 가장 늦게 오는 사람의 시간이 언제인지 저장시킨다.
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
                if(max<num){
                    max = num;
                }
            }

            // 3. 가장 늦게오는 사람의 시간까지 for문을 돌린다.
            for(int i=0; i<=max; i++){
                // 4. 빵 생성시기 : 현재시간 % M == 0 ( 1%2 도 0이니 예외처리 필요 )
                if(i>=M && i % M == 0){
                    bread += K;
                }
                if(!pq.isEmpty() && i == pq.peek()) {
                    if (bread > 0) {
                        do {
                            pq.poll();
                            bread--;
                            if(pq.isEmpty()){
                                break;
                            }
                        }while(pq.peek() == i);
                    }
                    else{
                        possible = false;
                        break;
                    }
                }
                if(bread<0){
                    possible = false;
                    break;
                }
                if(pq.isEmpty()){
                    break;
                }
            }

            if(possible){
                result = "Possible";
            }
            else{
                result = "Impossible";
            }

            System.out.printf("#%d %s",count,result);
            System.out.println();
            count++;
        }
    }
}
