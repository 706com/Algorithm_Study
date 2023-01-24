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
        int N = Integer.parseInt(st.nextToken());   //
        int r = Integer.parseInt(st.nextToken());   //행(row)
        int c = Integer.parseInt(st.nextToken());   //열(column)
        int size = (int)Math.pow(2,N);
        find(r,c,size);
    }

    public static void find(int newR,int newC, int size){
        if(size == 1){
            return;
        }
        int newSize = size / 2;
        if()
    }
}
