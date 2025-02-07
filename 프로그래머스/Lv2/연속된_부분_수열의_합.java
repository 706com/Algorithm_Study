package 프로그래머스.Lv2;

//[241115] 소요시간 : 1시간 30분 🔍
//[250208] 50분 🔍

import java.util.*;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> {
            if(o1.len == o2.len){
                return o1.left - o2.left;
            }
            return o1.len - o2.len;
        });

        int left = 0;
        int right = 0;
        int sum = sequence[left];
        while(true){
            // System.out.println(left+" "+right+" ::"+sum);
            if(sum == k){
                // System.out.println("check");
                pq.add(new Node(left,right));
            }

            if(left == sequence.length-1 && right == sequence.length-1){
                break;
            }
            // 누적합이 같거나 작을때 , 그리고 끝까지 도달하지 않았을 때 right 증가
            if(sum <= k && right < sequence.length-1){
                right++;
                sum += sequence[right];
            }

            else {
                sum -= sequence[left];
                left++;
            }
        }
        return new int[]{pq.peek().left,pq.peek().right};

    }
    class Node{
        int left;
        int right;
        int len;
        Node(int left, int right){
            this.left = left;
            this.right = right;
            len = right-left;
        }
    }
}
