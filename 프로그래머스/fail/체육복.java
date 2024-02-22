package 프로그래머스.fail;

import java.util.Arrays;

public class 체육복 {
    public int solution(int N, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] arr = new boolean[N+2];
        Arrays.fill(arr,true);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int x : lost){
            arr[x] = false;
        }
        System.out.println(Arrays.toString(arr));
        for(int x : reserve){
            if(arr[x-1] == false){
                arr[x-1] = true;
                continue;
            }
            if(arr[x] == false){
                arr[x] = true;
                continue;
            }
            if(arr[x+1] == false){
                arr[x+1] = true;
            }
        }
        for(int i=1; i<=N; i++){
            if(arr[i] == true){
                answer++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return answer;
    }
}
