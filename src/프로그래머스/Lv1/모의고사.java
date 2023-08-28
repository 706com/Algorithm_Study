package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = {0,0,0};

        int pointOne = 0;
        int pointTwo = 0;
        int pointThree = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<answers.length; i++){
            if(i%5 == 0){
                pointOne = 0;
            }
            if(i%8 == 0){
                pointTwo = 0;
            }
            if(i%10 == 0){
                pointThree = 0;
            }

            if(answers[i] == arr1[pointOne]){
                correct[0]++;
            }
            if(answers[i] == arr2[pointTwo]){
                correct[1]++;
            }
            if(answers[i] == arr3[pointThree]){
                correct[2]++;
            }
            pointOne++;
            pointTwo++;
            pointThree++;

            //5,8,10의 최소공배수 400(여기까지만 돌아도됨)
            if(i == 400){
                break;
            }
        }
        //최댓값 뽑아내기
        int max = Math.max(Math.max(correct[0],correct[1]),correct[2]);

        //최댓값과 일치하는 수포자만 리스트에 넣기
        for(int i=0; i<correct.length; i++){
            if(correct[i] == max){
                list.add(i+1);
            }
        }

        answer = new int[list.size()];

        //answer배열에 넣어주기
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//        int[] answers = {1,3,2,4,2};
        모의고사 sol = new 모의고사();
        sol.solution(answers);
    }
}
