package 프로그래머스.Lv2;

//소요시간 : 1시간 4분 (-> 문제 제대로 안읽어서 + 디버깅 안해서 폭풍 삽질 ㅜ)

public class 이진_변환_반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            int countZero = 0;

            int countOne = 0;
            // System.out.println("이진 변환 이전 : " + s);

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '0'){
                    answer[1]++;
                    countZero++;
                } else{
                    countOne++;
                }
            }

            // System.out.println("제거할 0의 개수 : " + countZero);
            answer[0]++;
            if(countOne == 1){
                return answer;
            }

            String binaryStr = Integer.toBinaryString(countOne);
            // System.out.println("이진 변환 결과 : " + binaryStr);

            while(true){
                countZero = 0;
                countOne = 0;
                // System.out.println("이진 변환 이전 : " + binaryStr);
                for(int i=0; i<binaryStr.length(); i++){
                    char c = binaryStr.charAt(i);
                    if(c == '0'){
                        answer[1]++;
                        countZero++;
                    } else{
                        countOne++;
                    }
                }
                // System.out.println("제거할 0의 개수 : " + countZero);
                answer[0]++;
                if(countOne == 1){
                    break;
                }
                binaryStr = Integer.toBinaryString(countOne);
                // System.out.println("이진 변환 결과 : " + binaryStr);
            }
            return answer;
        }
    }
}
