package 백준;
//[백준]1018 : 체스판 닷; 칠하기 - JAVA(자바)

//<새로 알게된 것>

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _1018_체스판_다시_칠하기 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로

        arr = new char[N][M];

        int result = 64;

        //배열에 입력받기
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        //8x8로 잘라서 보내기
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                result = Math.min(result ,paintChess(i,j));
                System.out.println();
            }
        }
        System.out.println(result);

    }
    public static int paintChess(int startN, int startM){
        char WB = ' ';
        int count = 0;

        int endN = startN + 8;
        int endM = startM + 8;

        System.out.println(arr[startN][startM]);
        //잘린 체스판의 처음이 'B' 일 때.
        if(arr[startN][startM] == 'B') {
            for (int i = startN; i < endN; i++) {
                //짝수번째(0,2,4,6)의 처음은 = B 이어야함
                if ((i-startN)%2 == 0) {
                    WB = 'B';
                }
                //홀수번째(1,3,5,7)의 처음은 = W 이어야함
                else if ((i-startN) % 2 == 1) {
                    WB = 'W';
                }
                for (int j = startM; j < endM; j++) {
                    if (arr[i][j] != WB) {
                        count++;
                    }

                    if (WB == 'B') {
                        WB = 'W';
                    } else if (WB == 'W') {
                        WB = 'B';
                    }
                }
            }
        }

        //잘린 체스판의 처음이 'W' 일 때.
        else if(arr[startN][startM] == 'W') {
            for (int i = startN; i < endN; i++) {
                //짝수번째(0,2,4,6)의 처음은 = W 이어야함
                if ((i-startN) % 2 == 0) {
                    WB = 'W';
                }
                //홀수번째(1,3,5,7)의 처음은 모두 B 이어야함
                else if ((i-startN) % 2 == 1) {
                    WB = 'B';
                }
                for (int j = startM; j < endM; j++) {
                    if (arr[i][j] != WB) {
                        count++;
                    }
                    if (WB == 'B') {
                        WB = 'W';
                    }
                    else if (WB == 'W') {
                        WB = 'B';
                    }
                }
            }
        }

        for(int i=startN; i<endN; i++){
            for(int j=startM; j<endM; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(count);
        return count;
    }
}
