package 프로그래머스.Lv2;

// <소요시간>
//[240423] : 25분
//[250207] : 25분
//[251027] : 16분

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            q.offer(new Node(progresses[i],speeds[i]));
        }

        List<Integer> list = new ArrayList<>();

        // 최대 100일
        for(int day=1; day<=100; day++){
            if(q.isEmpty()){
                break;
            }
            //날짜 기준 poll()
            int count = 0;
            while(!q.isEmpty()){
                Node nowNode = q.peek();
                // 배포 시작
                if(nowNode.progress + (nowNode.speed * day) >= 100){
                    q.poll();
                    count++;
                } else{
                    break;
                }
            }
            if(count != 0){
                // System.out.println(day);
                list.add(count);
            }
        }
        // System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    class Node{
        int progress;
        int speed;
        Node(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        @Override
        public String toString(){
            return this.progress + " " + speed;
        }
    }
}
