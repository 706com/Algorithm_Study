package BOJ._2_Silver;
//[백준]1780 : 종이의 개수 - JAVA(자바)

// 소요시간 : 20분(실패 : 구현실패)
// 소요시간 : 14분


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780_종이의_개수 {
    static int[][] board;
    static int N;
    static boolean check;

    static int countNegative = 0;
    static int countZero = 0;
    static int countPositive = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 3^7, N은 3^k 꼴)
        board = new int[N][N];

        //입력받기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초깃값 보내기
        paperCut(0,0, N);

        System.out.println(countNegative);
        System.out.println(countZero);
        System.out.println(countPositive);

    }

    public static void paperCut(int row , int col , int size){

        //색상이 모두 동일하면
        if(sameColor(row,col,size)){
            if(board[row][col] == -1){
                countNegative++;
            }
            else if (board[row][col] == 0){
                countZero++;
            }
            else if (board[row][col] == 1){
                countPositive++;
            }
            return;
        }

        //종이 자르기
        int newsize = size / 3;

        //윗쪽
        paperCut(row,col,newsize);                      //위 왼쪽
        paperCut(row,col+ newsize,newsize);         //위 가운데
        paperCut(row ,col +newsize*2,newsize);      //위 오른쪽

        //중앙
        paperCut(row + newsize , col,newsize);                 //중앙 왼쪽
        paperCut(row + newsize ,col+newsize,newsize);      //중앙 가운데
        paperCut(row + newsize ,col+newsize*2,newsize);    //중앙 오른쪽

        //아랫쪽
        paperCut(row + newsize*2, col,newsize);                  //아래 왼쪽
        paperCut(row + newsize*2, col+newsize,newsize);      //아래 가운데
        paperCut(row + newsize*2 ,col+newsize*2,newsize);    //아래 오른쪽

    }

    public static boolean sameColor(int row, int col, int size){
        int color = board[row][col];
        check = true;

        //해당 영역의 시작~끝까지 ex) 1*1 , 3*3 , 9*9
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                //하나라도 해당영역 색상과 다르면 false 반환
                if(color != board[i][j]){
                    return false;
                }
            }
        }
        //모두 같으면 true 반환
        return true;
    }
}
