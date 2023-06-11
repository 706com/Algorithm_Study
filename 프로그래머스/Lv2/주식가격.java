package 프로그래머스.Lv2;
//[프로그래머스] 주식가격 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//< 알고리즘 풀이 >

//< 새로 알게된 것 >

//< 궁금한 것 >

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        for(int i=0; i< prices.length; i++){
            int count = 0;
            for(int j=i+1; j< prices.length; j++){
                if(prices[i]>prices[j]){
                    count++;
                    break;
                }
                count++;
            }
            answer[i] = count;
        }

//        for(int i=0; i< prices.length; i++){
//            System.out.print(answer[i]+" ");
//        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        주식가격 sol = new 주식가격();
        sol.solution(prices);
    }
}
