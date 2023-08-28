package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            deq.offer(i);
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        while(!list.isEmpty()){
            int targetIndex = deq.indexOf(list.remove(0));     //indexOf() : LinkedList 로 deq 구현해야함
            int halfIndex;

            // deque의 사이즈 % 2 가 짝수면 index -1
            // ex) (1,2,3,4) % 2 ==  인덱스 2번째(3) -1
            if(deq.size() % 2 == 0){
                halfIndex = deq.size() / 2 -1;
            }
            else{
                halfIndex = deq.size() / 2;
            }

            //target 의 인덱스가 절반 인덱스보다 작다면 : 앞에있는걸 뒤로
            if(targetIndex <= halfIndex){
                for(int i=0; i<targetIndex; i++) {
                    deq.offerLast(deq.pollFirst());
                    count++;
                }
            }
            // target 의 인덱스가 절반 인덱스보다 크다면 : 뒤에있는걸 앞으로
            else{
                for(int i=0; i<deq.size() - targetIndex; i++){
                    deq.offerFirst(deq.pollLast());
                    count++;
                }
            }
            deq.pollFirst();
        }
        System.out.println(count);
    }
}
