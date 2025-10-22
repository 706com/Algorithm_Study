package 프로그래머스.Lv2;
//[프로그래머스] 주식가격 - JAVA(자바)

//[251022] 🔎

import java.util.*;

public class 주식가격 {
    /**
     * 스택 접근
     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Node> stk = new ArrayDeque<>();

        for(int i=0; i<prices.length; i++){
            Node nowNode = new Node(i,prices[i]);

            while(true){
                // 비어있으면 out
                if(stk.isEmpty()){
                    break;
                }
                Node beforeNode = stk.peek();

                // 현재 가격이 과거보다 작을 때 -> 기간 책정
                // 책정했으면 제거
                if(beforeNode.val > nowNode.val){
                    answer[beforeNode.idx] = nowNode.idx - beforeNode.idx;
                    stk.pop();
                } else{
                    break;
                }
            }
            stk.push(nowNode);
        }

        //남은 노드들은 끝까지 간 것 -> 기간 책정
        while(!stk.isEmpty()){
            Node remainNode = stk.pop();

            answer[remainNode.idx] = (prices.length -1) - remainNode.idx;
        }

        return answer;
    }

    class Node{
        int idx;
        int val;

        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }



    /**
     * 배열 접근
     * -> 통과는 했으나, 비효율적. O(N^2)
     */
    public int[] solution2(int[] prices) {
        int[] answer = {};
        List<Integer> list =  new ArrayList<>();

        for(int i=0; i<prices.length; i++){
            int start = prices[i];
            int count = 0;
            for(int j = i+1; j<prices.length; j++){
                if(start <= prices[j]){
                    count++;
                }
                //주식이 떨어진 순간. 그 이후로는 볼 필요 X
                else{
                    count++;
                    break;
                }
            }
            list.add(count);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
