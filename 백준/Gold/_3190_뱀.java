package 백준.Gold;
//[백준]3190 : 뱀 - JAVA(자바)

//< 나의 알고리즘 >

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3190_뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //보드 크기
        int K = Integer.parseInt(br.readLine());    //사과의 갯수
        int[][] board = new int[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];
        
        //사과 담기
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;

        }
    }
}
