package 프로그래머스.Lv3;

//[250114] 🔍

// 단순 배열로 계산하면 최소 1000 * 1000 * 250000 시간초과 발생
// r1 <= r2, c1<= c2 의 범위를 어떻게 관리할 수 있을까?

// 2차원 누적합 계산

import java.util.*;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;   //4
        int M = board[0].length;    //5

        int[][] prefix = new int[N+1][M+1];

        // 1) 누적합 입력
        for(int i=0; i<skill.length; i++){
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int damage = skill[i][5];

            //공격
            if(skill[i][0] == 1){
                damage = -damage;
            }

            prefix[r1][c1] += damage;
            prefix[r1][c2+1] += -damage;
            prefix[r2+1][c1] += -damage;
            prefix[r2+1][c2+1] += damage;
        }

        // 2) 누적합 계산 - 가로
        for(int i=0; i<=N; i++){
            for(int j=1; j<=M; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        // 3) 누적합 계산 - 세로
        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                prefix[i][j] += prefix[i-1][j];
            }
        }

        // for(int[] x : prefix){
        //     System.out.println(Arrays.toString(x));
        // }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] += prefix[i][j];
                if(board[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
