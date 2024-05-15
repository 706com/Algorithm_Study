package 프로그래머스.Lv1;

// 소요시간
//[240513] : 09:10 ~ 09:38 : 실패(생각 착각..)
//[240515] : 🔍

/*
error: incompatible types: char cannot be converted to CharSequence
                if(skip.contains(c))
    -> String.contains ->  char 형식이 아닌 String 형식으로 변경
    -> s.contains(String.valueOf(c))
*/

class 둘만의_암호 {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=0; j<index; j++){
                c++;

                // 'z'를 넘어가면 'a' 로 변경해준다.
                if(c=='z'+1){
                    c = 'a';
                }
                // skip에 포함되면 추가로 더 순회한다.
                if(skip.contains(String.valueOf(c))){
                    j--;    //한번 더 순회하기 위함.
                }
            }
            answer += c;
        }
        return answer;
    }
}