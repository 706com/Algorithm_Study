package 프로그래머스.Lv2;
//[프로그래머스] 같은 숫자는 싫어 - JAVA(자바)

// <소요시간>
// [240423] : 25분
//[250207] 25분

//  return answerList.stream().mapToInt(Integer::intValue).toArray();

import java.util.*;

public class 기능개발 {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        Queue<Node> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int days = remain / speeds[i];
            if(remain % speeds[i] != 0){
                days++;
            }
            Node node = new Node(i,days);
            q.offer(node);
        }
        int days = q.poll().days;

        int count = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            int nowDay = node.days;

            if(days>=nowDay){
                count++;
                continue;
            }
            days = nowDay;
            list.add(count);
            count=1;
        }
        list.add(count);
        return list;
    }

    class Node{
        int idx;
        int days;
        Node(int idx, int days){
            this.idx = idx;
            this.days= days;
        }
    }
}
