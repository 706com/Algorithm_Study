package 백준_Solved_Class_3;
//[백준]1012 : Z - JAVA(자바)

//<새로 알게된 것>
//분할정복 재귀 문제 (일반 재귀로 돌리면 시간초과)

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _1074_Z {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());   //행(row)
        int c = Integer.parseInt(st.nextToken());   //열(column)
        int size = (int)Math.pow(2,N);              //2^N == 한 변의 길이
        find(r,c,size);
    }

    public static void find(int r,int c, int size){
        //최종적으로 쪼개진 4분면사이즈
        if(size == 1){
            return;
        }

        //1사분면 -> count 증가없이, 사이즈만 줄이기
        if(r > size/2 && c > size/2){
            find(r,c,size/2);
        }
        //2사분면
        else if (r>=size/2 && c < size/2){
            count += size * size / 4;
            find(r,c-size/2,size/2);
        }
        //3사분면
        else if (r < size/2 && c>=size/2){
            count += (size * size / 4) * 2;
            find()

        }
    }
}
