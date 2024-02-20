package BOJ._3_Gold;

// < 알고리즘 유형 >
// 그리디

//소요시간 : 40분(실패 : 반례실패)
//소요시간 : 20분

// < 풀이 방법 >
// 음수, 0, 양수 로 나눠서 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1744_수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        Queue<Integer> zero = new LinkedList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                plus.add(num);
            }
            else if(num == 0){
                zero.add(num);
            }
            else{
                minus.add(num);
            }
        }
        int result = 0;
        while(true){
            if(plus.size()>=2){
                int now = plus.poll();
                if(now == 1){
                    result += now;
                    continue;
                }
                else {
                    if(plus.peek() == 1){
                        result += now;
                    }
                    else{
                        result += now * plus.poll();
                    }
                }
            }

            if(minus.size()>=2){
                result += minus.poll() * minus.poll();
            }

            if(plus.size() == 1){
                result += plus.poll();
            }
            if(minus.size() == 1){
                if(zero.size()!=0){
                    result += minus.poll() * zero.poll();
                }
                else{
                    result += minus.poll();
                }
            }

            if(plus.size()==0 && minus.size()==0){
                break;
            }
        }
        System.out.println(result);
    }
}
