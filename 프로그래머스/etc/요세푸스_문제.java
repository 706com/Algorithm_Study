package 프로그래머스.etc;

/*
<문제>
N명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 N까지 번호표를 가지고 있습니다.
그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다.

- 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다.
- 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다.

N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수를 구현하세요.

<제약사항>
1 <= N,K <= K

<입출력 예시>
N   K   return
5   2   3

1 2 3 4 5

*/

import java.util.*;

public class 요세푸스_문제 {
    public static int solution(int N, int K){
        Deque<Integer> deq = new LinkedList<>();
        for(int i=1; i<=N; i++){
            deq.offerFirst(i);
        }

        while(deq.size() != 1){
            for(int i=0; i<K-1; i++) {
                deq.offerLast(deq.pollFirst());
            }
            deq.pollFirst();
        }

        return deq.peekFirst();
    }

    public static void main(String[] args) {
        System.out.println(solution(5,2));  //3
    }
}
