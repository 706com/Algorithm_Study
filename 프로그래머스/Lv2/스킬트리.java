package 프로그래머스.Lv2;

//[250321] 26분

//1) 맵에 먼저 아전에, 담아야 할 정보 담아놓기
//2) 스택에 쌓아놓고, 이전이 있는지 확인

import java.util.*;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Character> map = new HashMap<>();

        map.put(skill.charAt(0),'0');
        //1) 맵에 먼저 아전에, 담아야 할 정보 담아놓기
        for(int i=1; i<skill.length(); i++){
            char c = skill.charAt(i);
            map.put(c,skill.charAt(i-1));
        }

        // for(char x : map.keySet()){
        //     System.out.println(x+" "+map.get(x));
        // }

        //2) 스택에 쌓아놓고, 이전이 있는지 확인
        for(String skills : skill_trees){
            boolean impossible = false;
            Stack<Character> stk = new Stack<>();

            for(int i=0; i<skills.length(); i++){
                char c = skills.charAt(i);

                //맵에 없는 정보면 넘어가기
                if(!map.containsKey(c)){
                    continue;
                }

                //만일 스택이 비어있으면 불가능
                if(stk.isEmpty()){
                    //첫 문자는 제외
                    if(map.get(c) == '0'){
                        stk.push(c);
                    } else{
                        impossible = true;
                        break;
                    }
                }
                //만일 peek()에 이전 값이 없으면 불가능
                else{
                    if(map.get(c) != stk.peek()){
                        impossible = true;
                        break;
                    }
                    stk.push(c);
                }
            }

            // 불가능하지 않으면 카운트 증가
            if(!impossible){
                answer++;
            }
        }
        return answer;
    }
}
