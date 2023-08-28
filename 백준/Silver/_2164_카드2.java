package 백준.Silver;

//< 알고리즘 유형 >
// 덱

//< 알고리즘 풀이 >
// 큐 상위호환인 덱을 활용하자 ! -> 이 좋은걸 왜안써?

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _2164_카드2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Deque<Integer> deq = new LinkedList<>();

        for(int i=1; i<=N; i++){
            deq.offer(i);
        }

        while(deq.size() != 1){

            deq.poll();

            if(deq.size()==1){
                break;
            }
            else{
                deq.offerLast(deq.pollFirst());
            }
        }
        System.out.println(deq.peek());
    }
}




