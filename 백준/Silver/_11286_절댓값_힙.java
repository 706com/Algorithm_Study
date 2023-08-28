package 백준.Silver;
//[백준]11286 : 절댓값 힙 - JAVA(자바)

// < 알고리즘 유형 >
// 우선순위 큐

// < 풀이방법 >
// 양수일 때, 음수일 때 각각 나눠서 운용

// < Remember ! >
// priority queue 는 최소힙이 디폴트 !


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> positiveNum = new PriorityQueue<>();
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){   // 0 이 아닐 때
                if(num < 0){
                    negativeNum.offer(num);
                }
                else if(num > 0){
                    positiveNum.offer(num);
                }
            }
            else{   //0 일 때
                if(positiveNum.isEmpty() && negativeNum.isEmpty()){
                    sb.append('0').append('\n');
                }
                else if(positiveNum.isEmpty()){
                    sb.append(negativeNum.poll()).append('\n');
                }
                else if(negativeNum.isEmpty()){
                    sb.append(positiveNum.poll()).append('\n');
                }
                else{   // 둘 다 안비었을 때
                    if(positiveNum.peek() < Math.abs(negativeNum.peek())) {
                        sb.append(positiveNum.poll()).append('\n');
                    }
                    else{
                        sb.append(negativeNum.poll()).append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
