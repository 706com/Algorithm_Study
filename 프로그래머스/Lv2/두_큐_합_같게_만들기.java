package 프로그래머스.Lv2;

//250110] 15분

import java.util.*;

public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long q1Sum = 0;
        long q2Sum = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q1Sum += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }

//        System.out.println(q1Sum+" "+ q2Sum);

        int count = 0;
        while(true){
            if(q1.isEmpty() || q2.isEmpty() || count >= 600000){
                return -1;
            }
            if(q1Sum == q2Sum){
                break;
            }
            else if(q1Sum > q2Sum){
                int num = q1.poll();
                q2.add(num);
                q2Sum += num;
                q1Sum -= num;

            } else{
                int num = q2.poll();
                q1.add(num);
                q1Sum += num;
                q2Sum -= num;
            }
            count++;
        }
        return count;
    }
}
