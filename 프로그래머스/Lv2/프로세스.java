package 프로그래머스.Lv2;
//[프로그래머스] 프로세스 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//[250820] : 12분

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(priorities[i],i));
            pq.offer(priorities[i]);
        }

        int cnt = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            //우선 순위가 해당 될 때
            if(node.priority >= pq.peek()){
                //내가 찾고 있는 것 일 때
                if(node.idx == location){
                    return cnt;
                } else{
                    cnt++;
                    pq.poll();
                    continue;
                }
            }
            //우선순위가 낮으면 뒤로 미루기
            q.offer(node);
        }
        return -1;
    }
    class Node {
        int priority;
        int idx;

        Node(int priorities, int idx) {
            this.priority = priorities;
            this.idx = idx;
        }
    }
}
