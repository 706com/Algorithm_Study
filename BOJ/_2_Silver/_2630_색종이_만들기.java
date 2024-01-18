package BOJ._2_Silver;
//[백준]2630 : 색종이 만들기 - JAVA(자바)

//소요시간 : 9분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630_색종이_만들기 {

    static int[][] arr;
    static int white,blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        searchAndCut(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
    static void searchAndCut(int row, int col, int size){
        if(search(row,col,size)){
            if(arr[row][col] == 0){
                white++;
            }
            else{
                blue++;
            }
        }
        else{
            size /= 2;

            searchAndCut(row,col,size);                     //2사분면
            searchAndCut(row,col+size,size);            //1사분면
            searchAndCut(row+size,col,size);            //3사분면
            searchAndCut(row+size,col+size,size);   //4사분면
        }
    }
    static boolean search(int row, int col,int size){
        int color = arr[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
