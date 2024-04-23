package 프로그래머스.Lv2;
//[프로그래머스] 같은 숫자는 싫어 - JAVA(자바)

// <소요시간>
// [240423] : 25분

// 최적화 방법 : 클래스 안에 미리 구해둔 기능완료 날짜를 넣어둔다.
// (int) Math.ceil(100.0/progresses[i]) / speeds[i] );

import java.util.*;

public class 기능개발 {
    /**
     * [240423]
     * 최적화 X -> 최적화 필요
     */
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        //1. 클래스 안에 인덱스, 진행률, 스피드를 담는다.
        //2. 클래스를 순서대로 큐에 담는다.
        for(int i=0; i<progresses.length; i++){
            Node node = new Node(i,progresses[i],speeds[i]);
            q.offer(node);
        }

        // for(Node x : q){
        //     System.out.println(x);
        // }

        // q 내부를 살펴본다.

        //3. 가장 상단의 인덱스를 기록한다.
        int maxIdx = -1;

        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for(int i=0; i<size; i++){
                Node node = q.poll();
                node.prs += node.spd;
                // System.out.println(node);
                //-> 100이 되면 해당 인덱스 부터 뒤에 100이 끝날때까지 카운트
                if(node.prs >= 100 && node.idx == maxIdx + 1){
                    count++;
                    maxIdx = node.idx;
                }
                //-> 100을 채우지 못하면 증가 후 뒤로
                else{
                    q.offer(node);
                }
            }
            //4. 카운트가 끝나면 answer 리스트에 담는다.
            if(count != 0){
                answerList.add(count);
            }
        }
        // System.out.println(answerList);

        //5. 리스트를 배열로 바꾼다.
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    class Node{
        int idx;
        int prs;
        int spd;
        Node(int i, int p,int s){
            idx = i;
            prs = p;
            spd = s;
        }
        @Override
        public String toString(){
            return "i " + idx + " prs " + prs + " spd " + spd;
        }
    }
/*-----------------------------------------*/
    public int[] solution_(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deq = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int remain = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] >0){
                remain +=1;
            }
            deq.add(remain);
        }

//        int size = deq.size();
//        for(int i=0; i<size; i++){
//            System.out.print(deq.poll()+" ");
//        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!deq.isEmpty()) {
            int count = 1 ;
            int now = 0;
            now = deq.poll();
            do {
                if(deq.isEmpty()){
                    break;
                }
                if (deq.peek() <= now) {
                    deq.poll();
                    count++;
                }
            } while (!deq.isEmpty() && deq.peek() <= now );
            list.add(count);
        }

//        for(int i=0; i<list.size(); i++){
//            System.out.print(list.get(i)+" ");
//        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        기능개발 sol = new 기능개발();
        sol.solution(progresses,speeds);

    }
}
