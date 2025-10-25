package 프로그래머스.fail;

//[251025] 실패 - 시간초과

import java.util.*;

public class 표_편집 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        // 조회 O(1), 삽입/삭제 O(N)
        List<Integer> list = new ArrayList<>();
        // 리스트 초기화 (0포함)
        for(int i=0; i<n; i++){
            list.add(i);
        }

        // list.add("무지");
        // list.add("콘");
        // list.add("어피치");
        // list.add("제이지");
        // list.add("프로도");
        // list.add("네오");
        // list.add("튜브");
        // list.add("라이언");
        // System.out.println(list);

        // 명령어 시작
        int currentIdx = k;
        Deque<Node> stk = new ArrayDeque<>();
        for(int i=0; i<cmd.length; i++){
            String[] parser = cmd[i].split(" ");
            char command = parser[0].charAt(0);
            int X = -1;

            switch(command){
                case 'U':   // 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
                    X = Integer.valueOf(parser[1]);
                    currentIdx = currentIdx-X;   // TODO : 맨 위보다 위 인덱스 일 경우?
                    break;
                case 'D':   // 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
                    X = Integer.valueOf(parser[1]);
                    currentIdx = currentIdx+X;  // TODO : 맨 아래보다 아래 인덱스 일 경우?
                    break;
                case 'C':   // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다.
                    // 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                    Integer value = list.remove(currentIdx);
                    // String value = "";

                    //완료 커맨드
                    stk.push(new Node(currentIdx, value));
                    if(currentIdx == list.size()){
                        currentIdx -= 1;
                    }
                    break;
                case 'Z':   // 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
                    Node node = stk.pop();
                    list.add(node.idx,node.value);
                    if(currentIdx >= node.idx){
                        currentIdx +=1;
                    }
                    break;
            }
            // System.out.println("명령어수행 : " + command +" " + X+" "+currentIdx);
            // System.out.println("결과 : " + list);
        }

        //최종 답안 도출
        StringBuilder sb = new StringBuilder();
        boolean[] table = new boolean[n];
        for(Integer x : list){
            table[x] = true;
        }
        for(int i=0; i<table.length; i++){
            if(table[i]){
                sb.append("O");
            } else{
                sb.append('X');
            }
        }

        // System.out.println(sb);

        return sb.toString();
    }
    class Node{
        int idx;
        Integer value;
        Node(int currentIdx,Integer value){
            this.idx = currentIdx;
            this.value = value;
        }
    }
}
