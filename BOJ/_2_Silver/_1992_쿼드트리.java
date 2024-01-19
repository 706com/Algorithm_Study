package BOJ._2_Silver;
//[백준]1992 : 쿼드트리 - JAVA(자바)

//소요시간 : 12분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        quad(0,0,N);
        System.out.println(sb);
    }

    static void quad(int row,int col,int size){
        if(check(row,col,size)){
            if(arr[row][col] == 0){
                sb.append("0");
            }
            else{
                sb.append("1");
            }
            return;
        }
        sb.append('(');
        size /= 2;

        quad(row,col,size);
        quad(row,col+size,size);
        quad(row+size,col,size);
        quad(row+size,col+size,size);

        sb.append(')');
    }

    static boolean check(int row, int col,int size){
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