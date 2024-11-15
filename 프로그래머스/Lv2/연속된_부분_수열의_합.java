package 프로그래머스.Lv2;

//[241115] 소요시간 : 1시간 30분 🔍

import java.util.*;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {

        int left = 0;
        int right = 0;
        int sum = sequence[right];

        List<Node> list = new ArrayList<>();

        while(true){

            if(sum == k){
                Node node = new Node(left,right);
                list.add(node);
                // System.out.println(list);
            }

            if(right == sequence.length-1 && left == sequence.length-1){
                break;
            }

            // 누적합이 k보다 적거나 같으면 이동한 right 합산
            if(sum <= k && right < sequence.length-1){
                sum += sequence[++right];
            }
            // 누적합이 k 보다 커졌으면 left값 빼고 이동
            else{
                sum -= sequence[left++];
            }
            // System.out.println("::::"+ left +" "+ right +" " + sum);
        }

        Collections.sort(list);
        return new int[]{list.get(0).left, list.get(0).right};
    }
    class Node implements Comparable<Node>{

        int left;
        int right;
        int len;

        Node(int left, int right){
            this.left = left;
            this.right= right;
            this.len = right-left;
        }

        public String toString(){
            return left + " " + right + " " + len;
        }
        public int compareTo(Node other){
            // len 이 같으면 left 가 짧은 것 오름차순
            if(this.len == other.len){
                return this.left - other.left;
            }

            // len이 짧을 때 오름차순
            return this.len - other.len;
        }
    }
}
