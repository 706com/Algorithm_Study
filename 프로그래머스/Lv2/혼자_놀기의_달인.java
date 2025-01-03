package 프로그래머스.Lv2;

//[250103] 17분

import java.util.*;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        int answer = 0;
        Node[] boxes = new Node[cards.length+1];
        List<Integer> list = new ArrayList<>();

        //박스 정보 입력
        for(int i=1; i<=cards.length; i++){
            boxes[i] = new Node(i,cards[i-1]);
        }

        //1번 박스부터 순회
        for(int i=1; i<boxes.length; i++){
            if(boxes[i].visited){
                continue;
            }

            // 돌면서 개수 세기
            int nowNum = i;
            int count =0;
            while(!boxes[nowNum].visited){
                boxes[nowNum].visited = true;
                nowNum = boxes[nowNum].num;
                count++;
            }
            list.add(count);
        }
        //내림차순 정렬
        Collections.sort(list,Collections.reverseOrder());

        //예외처리 : 분류된 박스 그룹이 1개면 0
        if(list.size() <=1){
            return 0;
        }
        return list.get(0) * list.get(1);
    }
    class Node{
        int idx;
        int num;
        boolean visited;
        Node (int idx, int num){
            this.idx = idx;
            this.num = num;
            visited = false;
        }
    }

}
