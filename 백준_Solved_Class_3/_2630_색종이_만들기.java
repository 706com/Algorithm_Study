package 백준_Solved_Class_3;
//[백준]2630 : 색종이 만들기 - JAVA(자바)

//< 나의 알고리즘 >
// 분할정복 ! , row, col ,size 를 사용하여 재귀를 타고 , 각 종이색깔의 카운트를 넣어야겠다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630_색종이_만들기 {
    static int N;
    static int[][] paper;
    static int countBlue =0;
    static int countWhite =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(paper[i][j]+" ");
//            }
//            System.out.println();
//        }

        makePaper(0,0,N);

        System.out.println(countWhite);
        System.out.println(countBlue);
    }

    static void makePaper(int row, int col , int size){

        if(isSame(row,col,size) == 0){
            countWhite++;
        }
        else if(isSame(row,col,size) == 1){
            countBlue++;
        }
        else{
            //사이즈 조정 후 각각 보내기
            size /= 2;

            makePaper(row,col,size);                //왼쪽 위  (1사분면)
            makePaper(row+size,col,size);       //오른쪽 위 (2사분면)

            makePaper(row,col+size,size);               //왼쪽 아래 (3사분면)
            makePaper(row+size,col+size,size);      //오른쪽 아래 (4사분면)
        }
    }

    static int isSame(int row, int col, int size){
        int check = paper[row][col];    //맨 처음 색깔로 기준잡기.

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                //하나라도 다르면 바로 return;
                if(paper[i][j] != check){
                    return -1;
                }
            }
        }

        //자른 색종이 색깔이 모두 같으면 0(white),1(blue) 중 리턴
        if(check == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
