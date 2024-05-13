package 프로그래머스.Lv1;

// 소요시간
// [240514] : 4분

public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0 ; i<absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            } else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
