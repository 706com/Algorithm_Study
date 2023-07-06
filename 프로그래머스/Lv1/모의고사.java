package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        int pointOne = 0;
        int pointTwo = 0;
        int pointThree = 0;
        //5,8,10 최소공배수 = 400

        PriorityQueue<Math> pq = new PriorityQueue<>((o1,o2)-> o2.value - o1.value);

        for(int i=0; i<answers.length; i++){
            if(i%5 == 0){
                pointOne = 0;
            }
            else if(i%8 == 0){
                pointTwo = 0;
            }
            else if(i%10 == 0){
                pointThree = 0;
            }

            if(answers[i] == arr1[pointOne]){
                answer[0] += 1;
            }
            if(answers[i] == arr2[pointTwo]){
                answer[1] += 1;
            }
            if(answers[i] == arr3[pointThree]){
                answer[2] += 1;
            }
            pointOne++;
            pointTwo++;
            pointThree++;

            //5,8,10의 최소공배수 400(여기까지만 돌아도됨)
            if(i == 400){
                break;
            }
        }

        for(int i=1; i<=3; i++){
            Math math = new Math(i,answer[i]);
            pq.offer(math);
        }


        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        모의고사 sol = new 모의고사();
        sol.solution(answers);
    }

    static class Math{
        int index;
        int value;

        Math(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
