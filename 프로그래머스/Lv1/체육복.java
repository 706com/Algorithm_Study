package 프로그래머스.Lv1;

//소요시간 : 1시간10분 (히든테케로 고생..-> 코드 너무 더러우니 다시 풀어볼 것)

import java.util.Arrays;

class 체육복 {
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

        //lost 인데 여유분 있는 사람 전처리
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]== reserve[j]){
                    arr[lost[i]] = true;
                    reserve[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(reserve));
        for(int i=0; i<reserve.length; i++){
            if(reserve[i] == 0){
                continue;
            }
            else if(arr[reserve[i]-1] == false){
                arr[reserve[i]-1] = true;
            }
            else if(arr[reserve[i]+1] == false){
                arr[reserve[i]+1] = true;
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