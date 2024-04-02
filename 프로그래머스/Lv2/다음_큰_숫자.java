package 프로그래머스.Lv2;

//소요시간 : 14분

public class 다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int count = 0;

            String binary = Integer.toBinaryString(n);

            for(int i=0; i<binary.length(); i++){
                char c = binary.charAt(i);
                if(binary.charAt(i) == '1'){
                    count++;
                }
            }
            // System.out.println(binary);
            // System.out.println(count);
            int num = n+1;
            while(true){
                int check =0;

                String binary2 = Integer.toBinaryString(num);
                for(int i=0; i<binary2.length(); i++){
                    if(binary2.charAt(i) == '1'){
                        check++;
                    }
                }
                if(check == count){
                    break;
                }
                num++;
            }
            return num;
        }
    }
}
