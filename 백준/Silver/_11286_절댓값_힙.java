package 백준.Silver;
//[백준]11286 : 절댓값 힙 - JAVA(자바)

//< 나의 알고리즘 >
// 양수 우선순위큐 , 음수 우선순위큐(큰 값부터) 2개를 선언하여
// 두개의 우선순위큐 중 , 절댓값으로 비교하여 출력 (정답)

//< 답안 알고리즘 >
// 2개 각각 선언보다, comparator , compare 로 절댓값으로 기준 잡는 것이 더 효율적.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num;
        boolean check = true;
        PriorityQueue<Integer> positiveNum = new PriorityQueue<>();
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            num = Integer.parseInt(br.readLine());
            // 0 일때
            if(num == 0){
                // 음수,양수 값이 모두 비어있으면 0출력
                if(positiveNum.isEmpty() && negativeNum.isEmpty()){
                    sb.append("0").append('\n');
                }
                else{
                    if(positiveNum.isEmpty()){
                        sb.append(negativeNum.poll()).append('\n');
                    }
                    else if(negativeNum.isEmpty()){
                        sb.append(positiveNum.poll()).append('\n');
                    }
                    else{
                        if(positiveNum.peek()<Math.abs(negativeNum.peek())){
                            sb.append(positiveNum.poll()).append('\n');
                        }
                        else{
                            sb.append(negativeNum.poll()).append('\n');
                        }
                    }
                }
            }
            // 0이 아닐때
            else{
                if(num>0){
                    positiveNum.offer(num);
                }
                else{
                    negativeNum.offer(num);
                }
            }
        }
        System.out.println(sb);
    }
}
