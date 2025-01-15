package 프로그래머스.Lv2;

//[250115] 🔍

import java.util.*;

public class 양궁대회 {

    int maxScore = 0;   //최대 점수 차
    int[] aInfo;    //어피치 과녁 정보
    int[] lInfo;    //라이언 과녁 정보
    int[] answer = {};  //최종 과녁 정보

    public int[] solution(int n, int[] info) {

        aInfo = info;
        lInfo = new int[info.length];

        dfs(0,n);
        // System.out.println(maxScore);

        //라이온이 이기는 경우가 없으면 -1 리턴
        if(maxScore == 0){
            return new int[]{-1};
        }
        return answer;
    }

    // depth : 현재 인덱스
    // dart : 남은 다트 수
    public void dfs(int depth, int dart){

        // 탈출조건 :  끝까지 돌았을 때
        if(depth == 11){
            // 남은 화살은 마지막에 추가
            if (dart > 0) {
                lInfo[10] += dart;
            }

            // 다트를 모두 소모 했을 때 계산
            int aScore = 0; //어피치 점수
            int lScore = 0; //라이온 점수

            // 점수 차 계산
            for(int i=0; i<11; i++){
                //둘 다 0 이면 통과
                if(aInfo[i] == 0 && lInfo[i] == 0){
                    continue;
                }
                //어피치 승
                if(aInfo[i] >= lInfo[i]){
                    aScore += 10-i;
                }
                //라이온 승
                else{
                    lScore += 10-i;
                }
            }

            //라이온이 이겼을 때
            if(lScore>aScore){
                int diff = lScore - aScore;

                //현재 점수차가 가장 클 때
                if(diff > maxScore){
                    maxScore = diff;
                    answer = lInfo.clone();
                }

                //점수차가 같을 때 : 가장 낮은 점수를 더 많이 맞힌 경우
                else if(diff == maxScore){
                    for(int i = 10; i >= 0; i--){
                        // 기존 답과 비교해서 더 낮은 값이 크면 바꿔치기 하기
                        if(answer[i] < lInfo[i]){
                            answer = lInfo.clone();
                            break;
                        }
                        // --> 근데 기존 답 중에, 더 낮은 값이 크면 안 바꿔쳐야 하므로 break 했어야 함!
                        else if(answer[i] > lInfo[i]){
                            break;
                        }
                    }
                }
            }
            // 남은 화살 복구
            if (dart > 0) {
                lInfo[10] -= dart;
            }
            return;
        }

        //라이온 승
        // 어피치 +1 개 보다 더 많이 소모
        if (dart > aInfo[depth]) {
            lInfo[depth] = aInfo[depth] + 1;
            dfs(depth + 1, dart - (aInfo[depth] + 1));
            lInfo[depth] = 0;
        }

        //어피치 승
        //다트 소모 X
        dfs(depth + 1, dart);

    }
}
