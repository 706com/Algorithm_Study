package 백준;
//[백준]18111 : 마인크래프트 - JAVA(자바)

//<새로 알게된 것>
//초기화 할때 Integer.MAX_VALUE, Integer.MIN_VALUE 활용하기

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());   //세로
        int M = Integer.parseInt(st.nextToken());   //가로
        int B = Integer.parseInt(st.nextToken());   //가지고있는 블록

        int[][] arr = new int[N][M];
        int max = 0;
        int min = 256;

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        //입력받기 + 최댓값,최솟값 도출
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
                if(min > arr[i][j]){
                    min = arr[i][j];
                }
            }
        }

        //최소층부터 최대층까지 시간 탐색하기 (브루트포스)
        for(int floor=min; floor<=max; floor++){
            int time = 0;
            int haveBlock = B;

            //블록 탐색
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    //해당 층보다 블록이 높게 쌓여 있을 때 : 블록 제거 (2초)
                    if(arr[i][j] > floor){
                        time += (arr[i][j]- floor) * 2;
                        haveBlock += (arr[i][j] - floor);
                    }
                    //해당 층보다 블록이 낮게 쌓여 있을 때 : 블록 쌓기(1초)
                    else if(arr[i][j] < floor){
                        time += (floor - arr[i][j]);
                        haveBlock -= (floor - arr[i][j]);
                    }
                }
            }
            if(haveBlock >= 0 && minTime >= time ){
                minTime = time;
                maxHeight = floor;
            }
            //System.out.println("time: "+time+" minTime: "+minTime+" maxHeight: "+maxHeight);
        }
        System.out.println(minTime + " " + maxHeight);
    }
}
