package 프로그래머스.Lv2;
//[프로그래머스] 전화번호 목록 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
// 1. 해쉬에 전화번호 담기.
// 2. 각 전화번호의 substring 으로 해쉬에서 접두어 찾기.
// 3. 접두어 있으면 false 없으면 true 리턴

//< 새로 알게된 것 >
// substring

//< 궁금한 것 >


import java.util.HashMap;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String,Integer> map = new HashMap<>();

        //hash 에 전화번호부 담기
        for(String phone : phone_book){
            map.put(phone,map.getOrDefault(phone,0)+1);
        }

        // 각 전화번호의 substring 으로 해쉬에서 접두어 찾기.
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //String[] phone_book = {"119", "97674223", "1195524421"};
        //String[] phone_book = {"123","456","789"};
        String[] phone_book = {"12","123","1235","567","88"};

        전화번호_목록 sol = new 전화번호_목록();
        System.out.println(sol.solution(phone_book));
    }
}
