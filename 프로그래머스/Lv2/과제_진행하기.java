package 프로그래머스.Lv2;

//[241115] 소요시간 : 2시간 30분

// 1. start 시간 커스텀 및 시작시간 기준 정렬
// 2. 필요한 변수 start , playtime(remaining), nowTime
// 3. remain + nowTime <= 다음 작업과 비교
// 3-1) remain + nowTime 이 다음작업보다 작으면 바로 결과
// 3-2) 그렇지 않으면 스택에 담기

// 접근 알고리즘 : 스택,우선순위큐

import java.util.*;

public class 과제_진행하기 {
    public String[] solution(String[][] plans) {
        String[] answer = {};

        List<Node> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        List<String> result = new ArrayList<>();

        StringTokenizer st;
        int nowTime;

        // 1. start 시간 커스텀 및 시작시간 기준 정렬
        for(String[] sub : plans){
            Node node;
            String name = sub[0];
            st = new StringTokenizer(sub[1],":");
            int hour = Integer.parseInt(st.nextToken()) * 60;
            int min = Integer.parseInt(st.nextToken());
            int start = hour + min;
            int remain = Integer.parseInt(sub[2]);

            pq.add(new Node(name,start,remain));
        }
        // System.out.println(pq);

        while(!pq.isEmpty()){
            //1. 대기중인 과제 꺼내기
            Node nowNode = pq.poll();
            nowTime = nowNode.start;

            // 시작시간 기준, 과제가 쌓여있을 때
            if(!pq.isEmpty()){
                Node nextNode = pq.peek();

                // 2. 현재 작업이 다음 작업 시작 전에 끝나는 경우
                // -> 바로 완료 과제에 넣기
                // -> 현재 시간 = 현재과제 + 플레이타임
                if(nowTime + nowNode.remain <= nextNode.start){
                    result.add(nowNode.name);
                    nowTime += nowNode.remain;

                    // 3. 스택 확인
                    // -> 만일 비어있지 않은데, 다음 과제보다 일찍 끝낼 수 있으면 완료 과제에 넣기
                    while(!stk.isEmpty()){
                        Node stkNode = stk.pop();

                        // 4. 다음작업보다 일찍 끝날 수 있으면 완료 과제에 넣기
                        if(nowTime + stkNode.remain <= nextNode.start){
                            // Node stkNode = stk.pop();
                            result.add(stkNode.name);
                            nowTime += stkNode.remain;
                        }
                        // 4.그렇지 않으면 playtime 감소 시키고 다시 넣고 다음작업 실시
                        else{
                            stkNode.remain -= (nextNode.start-nowTime);
                            stk.push(stkNode);
                            break;
                        }
                    }
                }
                // 2. 현재 작업이 다음 작업 시작 전에 안끝날 경우
                // -> 스택에 넣기
                else {
                    nowNode.remain -= (nextNode.start - nowNode.start);
                    stk.push(nowNode);
                }
            }
            // 1. 마지막 작업 처리
            else {
                result.add(nowNode.name);

                while (!stk.isEmpty()) {
                    Node stkNode = stk.pop();
                    result.add(stkNode.name);
                }
            }
        }

        answer = new String[result.size()];

        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    class Node implements Comparable<Node>{
        String name;
        int start;
        int remain;

        Node(String name, int start, int remain){
            this.name = name;
            this.start = start;
            this.remain = remain;
        }

        public String toString(){
            return "NODE : "+ name+" "+start+" "+remain;
        }

        public int compareTo(Node other){
            return this.start - other.start;
        }
    }
}
