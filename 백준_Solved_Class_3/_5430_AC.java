package 백준_Solved_Class_3;
//[백준]5430 : AC - JAVA(자바)

//< 나의 알고리즘 >
// deQueue ? 문제같다. R 을 기점으로 뒤를 뺄지 앞으로 뺄지 결정하면 될 것 같은데 긴가민가하다.
// 접근은 잘 했는데 런타임 에러가 뜬다. 그리고 무엇보다 코드가 너무 더럽다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트케이스 T는 최대 100 (4)

        while(T-- > 0) {
            // sb 초기화
            StringBuilder sb = new StringBuilder();

            String p = br.readLine();   //수행할 함수 p : (1 <= p <= 100,000) (RDD)
            int n = Integer.parseInt(br.readLine());    //배열에 들어있는 수의 개수 n (0 ≤ n ≤ 100,000) (4)
            Deque<Integer> deq = new LinkedList<>();

            String num = br.readLine(); //[1,2,3,4]

//            if(n == 0){
//                System.out.println("error");
//                continue;
//            }

            //deq 안에 숫자만 뽑아내서 넣기. [1,2,3,4] -> 1 2 3 4
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (Character.isDigit(c)) {
                    deq.offer(Character.getNumericValue(c));
                }
            }

            String way  = "LToR";
            int count = 0;

            if(!deq.isEmpty()) {
                for (int i = 0; i < p.length(); i++) {
                    char command = p.charAt(i);

                    //방향정하기
                    if (command == 'R') {
                        if (way.equals("LtoR")) {
                            way = "RtoL";
                        } else {
                            way = "LtoR";
                        }
                    }

                    //방향에 의한 출력값 지정
                    if (command == 'D') {
                        count++;
                        if (way.equals("LtoR")) {
                            deq.removeLast();
                        } else {
                            deq.removeFirst();
                        }
                    }
                }
            }

            //deq 에 들어있는 사이즈보다 D의 개수가 많으면 error출력 후 넘어가기
            if(n < count){
                System.out.println("error");
                continue;
            }

            sb.append("[");
            while(!deq.isEmpty()){
                if (way.equals("LtoR")) {
                    sb.append(deq.removeLast()).append(",");
                } else {
                    sb.append(deq.removeFirst()).append(",");
                }
            }

            if(sb.charAt(sb.length()-1) == ',') {
                sb.delete(sb.length() - 1, sb.length());
            }

            sb.append("]");
            System.out.println(sb);
        }
    }
}
