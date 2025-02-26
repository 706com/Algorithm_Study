package BOJ._3_Gold;
//[백준]1931 : 회의실 배정 - JAVA(자바)

//[240219] 31분
//[250226] 10분

import java.io.*;
import java.util.*;

public class _1931_회의실_배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N =Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(o1, o2)-> {
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count =0;
        int lastTime =0;
        for(int i=0; i<N; i++){
            if(lastTime<=arr[i][0]){
                lastTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
