package 프로그래머스.Lv1;

//소요시간
//[240517] : 5분

public class 콜라츠_추측 {

    public int solution(int num) {
        int answer = 0;

        while(num>1){
            if(num % 2 == 0){
                num/=2;
                answer++;
                continue;
            }
            if(num % 2 == 1){
                num = num *3 +1;
                answer++;
            }
        }
        if(num != 1){
            return -1;
        }
        return answer;
    }
}
