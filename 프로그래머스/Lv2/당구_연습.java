package 프로그래머스.Lv2;

//[241121] 소요시간 : 1시간 40분 🔍

import java.util.*;

public class 당구_연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for(int i=0; i<balls.length; i++){
            int min = Integer.MAX_VALUE;
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int resultX = 0;
            int resultY = 0;
            //좌(-x,y)  : y 가 같을 때 타겟 x 가 작으면 안됨
            if(!(startY == targetY && startX >= targetX)){
                resultX = targetX*(-1) - startX;
                resultY = targetY - startY;
                min = Math.min(min, (int)Math.pow(resultX,2) + (int)Math.pow(resultY,2));
            }

            //하(x,-y) : x 가 같을 때 타겟 y 가 작으면 안됨
            if(!(startX == targetX && startY >= targetY)){
                resultX = targetX - startX;
                resultY = targetY*(-1) - startY;
                min = Math.min(min, (int)Math.pow(resultX,2) + (int)Math.pow(resultY,2));
            }

            //우(2m-x,y) : y가 같을 때 타겟 x가 크면 안됨
            if(!(startY == targetY && startX <= targetX)){
                resultX = (2 * m - targetX) - startX;
                resultY = targetY - startY;
                min = Math.min(min, (int)Math.pow(resultX,2) + (int)Math.pow(resultY,2));
            }

            //상(x,2n-y)
            if(!(startX == targetX && startY <= targetY)){
                resultX = targetX - startX;
                resultY = (2 * n - targetY) - startY;
                min = Math.min(min, (int)Math.pow(resultX,2) + (int)Math.pow(resultY,2));
            }

            answer[i] = min;
        }

        return answer;
    }
}
