package BOJ._2_Silver;

//소요시간 : 10분 (실패) -> 정답확인
//소요시간 : 21분

// < Remember >
// Deque 선언보다 LinkedList 선언이 용이함. (indexOf() 활용)
// LinkedList는 모든 메서드 사용가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021_회전하는_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            deq.offer(i);
        }

        //뽑는 수 배열에 저장
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        //찾기
        for(int i=0; i<M; i++){
            int num = arr[i];
            int targetIndex = deq.indexOf(num);
            int halfIndex = deq.size() / 2;

            // 1번. 맨 앞에 있으면 뽑기 (count는 안함)
            if(deq.peekFirst() == num){
                deq.pollFirst();
                continue;
            }

            // 3번. deq에 사이즈보다, 찾고자 하는 수의 인덱스가 뒤에 있을때
            if(halfIndex < targetIndex){
                while(true){
                    deq.offerFirst(deq.pollLast());
                    count++;
                    //찾고자 하는수가 맨 앞에 배치되면 탈출
                    if(deq.peekFirst() == num){
                        deq.pollFirst();
                        break;
                    }
                }
            }
            // 2번. deq 사이즈보다, 찾고자 하는 수의 인덱스가 앞에 있을때
            else{
                while(true){
                    deq.offerLast(deq.pollFirst());
                    count++;
                    //찾고자 하는수가 맨 앞에 배치되면 탈출
                    if(deq.peekFirst() == num){
                        deq.pollFirst();
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}