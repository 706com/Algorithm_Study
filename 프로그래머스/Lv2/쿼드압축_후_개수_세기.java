package 프로그래머스.Lv2;

//[250226] 26분

import java.util.*;

public class 쿼드압축_후_개수_세기 {

    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {

        resize(arr, arr.length);

        return new int[]{zero,one};
    }
    public void resize(int[][] arr, int N){

        // 다른게 있는지 체크
        boolean checkSame = true;
        int num = arr[0][0];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(num != arr[i][j]){
                    checkSame = false;
                    break;
                }
            }
            if(!checkSame){
                break;
            }
        }

        // 같으면 갯수 세고 리턴
        if(checkSame){
            if(num == 0){
                zero++;
            } else{
                one++;
            }
            return;
        }

        // 다르면 쪼개기 (4등분)
        N /= 2;
        if(N==0){
            return;
        }

        // 2,1,3,4 분면 체크
        int[][] newArr = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newArr[i][j] = arr[i][j];
            }
        }
        resize(newArr, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newArr[i][j] = arr[i][j+N];
            }
        }
        resize(newArr, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newArr[i][j] = arr[i+N][j];
            }
        }
        resize(newArr, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newArr[i][j] = arr[i+N][j+N];
            }
        }
        resize(newArr, N);
    }
}
