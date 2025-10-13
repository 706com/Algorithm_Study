package 프로그래머스.Lv2;

//소요시간 : 1시간 15분 🔍
//[251013] : 30분

import java.util.*;

public class 방문_길이 {
    public int solution(String dirs) {
        int answer = 0;

        // 이동한 위치를 key - value 형태로 관리
        Set<String> visited = new HashSet<>();

        int x = 0;
        int y = 0;

        for(int i=0; i<dirs.length(); i++){
            // String 형태로 출발 key 변환
            String moveBeforeKey = String.valueOf(x)+" "+String.valueOf(y);

            char c = dirs.charAt(i);
            switch(c){
                case 'U':
                    if(y < 5){
                        y++;
                    }
                    break;
                case 'D':
                    if(y > -5){
                        y--;
                    }
                    break;
                case 'R':
                    if(x < 5){
                        x++;
                    }
                    break;
                case 'L':
                    if(x > -5){
                        x--;
                    }
                    break;
            }

            // String 형태로 도착 key 변환
            String moveAfterKey = String.valueOf(x)+" "+String.valueOf(y);

            // 이동한 형태를 key 로 생성 (양방향)
            // 이동을 안했으면(이동한 지점이 같으면) 저장 x
            if(!moveBeforeKey.equals(moveAfterKey)){
                visited.add(moveBeforeKey+" "+moveAfterKey);
                visited.add(moveAfterKey+" "+moveBeforeKey);
            }
        }

        return visited.size() / 2;
    }

}
