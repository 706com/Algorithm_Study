package 프로그래머스.Lv2;
//[프로그래머스] 가장 큰 수 - JAVA(자바)

//< 알고리즘 유형 >
// 정렬

//< 알고리즘 풀이 >
// 맨 앞자리 기준으로 정렬 시키면 가장 큰 수가 될 것 같다. -> 시간초과 + 비효율
// -> comparator 로 (b+a).compareTo(a+b) 처럼 문자열을 비교하여 정렬시킨다. 610 > 106

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o2.num - o1.num);

        int[] temp = new int[numbers.length];
        String answer = "";

        for(int i=0; i<numbers.length; i++){
            if(numbers[i]/10 == 0){
                temp[i] = numbers[i]%10;
            }
            else{
                temp[i] = numbers[i]/10;
            }
        }

        for(int i=0; i<numbers.length; i++){
            Node node = new Node(i,temp[i]);
            pq.offer(node);
        }

        for(int i=0; i< numbers.length; i++){
            String str = String.valueOf(numbers[pq.poll().index]);
            answer += str;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
//        int[] numbers= {6, 10, 2};
        int[] numbers= {3, 30, 34, 5, 9};


        가장_큰_수 sol = new 가장_큰_수();
        sol.solution(numbers);
    }

    class Node{
        int index;
        int num;
        Node(int index,int num){
            this.index=index;
            this.num = num;
        }
    }
}
