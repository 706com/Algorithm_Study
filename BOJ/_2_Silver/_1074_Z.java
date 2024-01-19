package BOJ._2_Silver;
//[백준]1012 : Z - JAVA(자바)

//소요시간 : 20분(실패 : 구현실패)
//소요시간 : 30분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074_Z {
    static int N,r,c;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());   //row
        c = Integer.parseInt(st.nextToken());   //col

        search(r,c,(int)Math.pow(2,N));
    }
    static void search(int row, int col, int size){
        if(size == 1){
            System.out.println(count);
            return;
        }

        size /= 2;
        if(row < size && col < size){
//            count += size*size;
            search(row,col,size);
        }
        else if(row<size && col>=size){
            count += size*size;
            search(row,col-size,size);
        }
        else if(row>=size && col<size){
            count += size*size*2;
            search(row-size,col,size);
        }
        else if (row>=size && col>=size){
            count += size*size*3;
            search(row-size,col-size,size);
        }
    }
}
