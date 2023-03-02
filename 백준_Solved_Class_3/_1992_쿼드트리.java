package 백준_Solved_Class_3;
//[백준]1992 : 쿼드트리 - JAVA(자바)

//< 나의 알고리즘 >
// 분할정복! 사이즈 조정이랑 row,col 을 사용하여 재귀 타기.

//< 답안 알고리즘 >
//

//< 새로 알게된 것 >


//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {
    static int[][] board;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64
        board = new int[N][N];

        //입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                board[i][j] = Character.getNumericValue(c);
            }
        }

        quadTree(0,0,N);

        System.out.println(sb);

    }

    public static void quadTree(int row , int col , int size){

        //모두 같은 숫자면
        if(isSame(row,col,size) == 1){
            sb.append("1");
        }
        else if(isSame(row,col,size) == 0){
            sb.append("0");
        }
        else{
        if(size >= 1) {
            sb.append("(");
            size /= 2;
            quadTree(row, col, size);                     //왼쪽 위
            quadTree(row, col + size, size);            //오른쪽 위
            quadTree(row + size, col, size);            //왼쪽 아래
            quadTree(row + size, col + size, size);  //오른쪽 아래
            sb.append(")");
        }
    }
}

    public static int isSame(int row , int col ,int size){
        int color = board[row][col];        //현재 색상지정

        //해당 영역의 시작~끝까지 탐색 ex) 1*1 , 2*2 , 4*4
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                //하나라도 다르면 false처리 하고 -1리턴
                if(color != board[i][j]){
                    return -1;
                }
            }
        }
        // color 의 0 혹은 1 리턴
        return color;
    }
}
