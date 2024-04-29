package 프로그래머스.Lv1;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                return "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}
