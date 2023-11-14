package BOJ._1_Bronze;
//[백준]10250 : ACM호텔 - JAVA(자바)

// <새로 알게된 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10250_ACM호텔  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            sb.append(ACMhotel(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    public static String ACMhotel(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        int H = Integer.parseInt(st.nextToken()); //호텔의 층
        int W = Integer.parseInt(st.nextToken()); //각 층의 방 갯수
        int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지

        //배열이 있다고 생각하여 풀면 이해가 빠르지만 사실 이 풀이에선 배열이 쓰이지 않는다.
        //boolean checkIn[][] = new boolean[H+1][W+1];


        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                //배열이 있다고 생각하여 풀면 이해가 빠르지만 사실 이 풀이에선 배열이 쓰이지 않는다.
                //checkIn[j][i] = true;

                N--; //방을 배정하는 과정
                if(N==0){
                    // 일의자리는 101 102 103 식으로 진행되기에 방 번호에 "0" 추가 하여 층, 방 출력
                    if(i<10) {
                        String result = Integer.toString(j) + "0" + Integer.toString(i);
                        return result;
                    }
                    // 10 이상부터는 상관없기에 그대로 층, 방 번호 출력
                    else{
                        String result = Integer.toString(j) + Integer.toString(i);
                        return result;
                    }
                }
             }
        }
        //for 문 안에서 다 돌아야 하기에 만일 인원이 방의 갯수보다 많으면 에러 (호텔 꽉 참)
        return "호텔 꽉 참";
    }

}
