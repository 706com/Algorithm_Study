package 프로그래머스.Lv2;

//소요시간 : 17분
//[240607] : 35분
//[250218] 57분
//[251016] 20분

import java.util.*;

public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put(']','[');
        hm.put('}','{');
        int count = 0;
        while(count != s.length()){
            //0. 스택을 비우고 문자열을 초기화 시킨다.
            stk.clear();
            boolean error = false;
            //1. '[','(','{' 가 나오면 스택에 넣는다.
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c=='[' || c=='(' || c=='{'){
                    stk.push(c);
                } else{ //2. 나머지가 나오면 스택의 상단이랑 비교한다.
                    //2-0) 비어있으면 바로 끝낸다.
                    if(stk.isEmpty()){
                        error = true;
                        break;
                    }
                    //2-1) 올바르지 못하면 바로 끝낸다.
                    if(stk.peek() != hm.get(c)) {
                        error = true;
                        break;
                    }
                    //2-2) 모두 올바르면 통과.
                    else{
                        stk.pop();
                    }
                }
            }
            //(2) 과정이 올바르면 카운트를 증가시킨다
            if(stk.isEmpty() && !error){
                answer++;
            }
            //3. 문자열을 새로 조작하고 (0)부터 반복한다. substring,concat
            String first = s.substring(0,1);
            s = s.substring(1);
            s = s.concat(first);
            count++;
        }

        return answer;
    }


    public int solution2(String s) {

        // 1. 문자열 조합의 수 계산 (Set)
        Set<String> set = new HashSet<>();

        // 2. 중복제거 돌리기
        for(int i=0; i<s.length(); i++){
            // String + 연산이 좋지 않지만 양이 적으므로..
            s = s.substring(1,s.length())+s.substring(0,1);
            set.add(s);
        }

        // 각 조합 갯수 세기
        int answer = 0;
        for(String x : set){
            Deque<Character> stk = new ArrayDeque<>();
            boolean failFlag = false;

            for(int i=0; i<x.length(); i++){
                char c = x.charAt(i);

                if(c=='('||c=='{'||c=='['){
                    stk.push(c);
                } else{
                    // 비어있으면 실패
                    if(stk.isEmpty()){
                        failFlag = true;
                        break;
                    }
                    if(c==')' && stk.peek() == '('){
                        stk.pop();
                    } else if(c=='}' && stk.peek() == '{'){
                        stk.pop();
                    } else if(c==']' && stk.peek() == '['){
                        stk.pop();
                    } else{ // 조건 부합하지 않으면 실패
                        failFlag = true;
                        break;
                    }
                }
            }
            if(!failFlag && stk.isEmpty()){
                answer++;
            }
        }

        return answer;
    }
}

