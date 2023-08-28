package 프로그래머스.Lv2;
//[프로그래머스] 프로세스 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//< 알고리즘 풀이 >
// 큐 안에 클래스로 저장시켜, 우선순위와 인덱스를 동시저장

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        int max = -1;
        int answer = 1;

        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(i,priorities[i]));
            list.add(priorities[i]);
        }

        Collections.sort(list,Collections.reverseOrder());
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.priority != list.get(0)){
                q.offer(node);
            }
            else if(node.priority == list.get(0) && node.index != location){
                list.remove(0);
                answer++;
            }
            else if (node.priority == list.get(0) && node.index == location){
                System.out.println(answer);
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] priorities = {2,1,3,2};
        int[] priorities = {1,1,9,1,1,1};
//        int location = 2;
        int location = 0;


        프로세스 sol = new 프로세스();
        sol.solution(priorities,location);
    }

    static class Node{
        int index;
        int priority;
        Node(int index,int priority){
            this.index = index;
            this.priority = priority;
        }
    }
}
