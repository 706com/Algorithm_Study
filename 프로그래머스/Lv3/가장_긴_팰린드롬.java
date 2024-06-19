package 프로그래머스.Lv3;

// 소요시간
// [240619] : 17분 (실패 - StringBuilder - reverse 접근) 🔍
// [240619] : 13분

public class 가장_긴_팰린드롬 {
    public int solution(String s){
        int maxOdd = 1;
        //홀수
        for(int i=0; i<s.length(); i++){
            int max = 1;
            int point = i;
            int toLeft = i-1;
            int toRight = i+1;
            while(true){
                if(toLeft<0 || toRight>=s.length()){
                    break;
                }
                if(s.charAt(toLeft) == s.charAt(toRight)){
                    max +=2;
                    toLeft--;
                    toRight++;
                } else{
                    break;
                }
            }
            maxOdd = Math.max(maxOdd,max);
        }

        int maxEven = 0;
        //짝수
        for(int i=0; i<s.length(); i++){
            int max = 0;
            int toLeft = i;
            int toRight = i+1;
            while(true){
                if(toLeft<0 || toRight>=s.length()){
                    break;
                }
                if(s.charAt(toLeft) == s.charAt(toRight)){
                    max +=2;
                    toLeft--;
                    toRight++;
                } else{
                    break;
                }
            }
            maxEven = Math.max(maxEven,max);
        }
        return Math.max(maxOdd,maxEven);
    }
}
