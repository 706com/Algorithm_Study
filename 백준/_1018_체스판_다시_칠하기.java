package 백준;
//[백준]1018 : 체스판 닷; 칠하기 - JAVA(자바)

//<새로 알게된 것>

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로

        char[][] arr = new char[N][M];
        int count = 0;

        //배열에 입력받기
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i+8<N; i+=2){
            String str = br.readLine();
            for(int j=0; j+8<M; j+=2){
                if(arr[i][j] != 'B'){
                    count +=1;

                }

            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
