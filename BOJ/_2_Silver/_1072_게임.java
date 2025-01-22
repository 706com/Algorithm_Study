package BOJ._2_Silver;

//[250122] 20분

import java.util.*;
import java.io.*;

public class _1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = (long)Math.floor(Y * 100) / X;
        long left = 1;  //최소 게임 횟수
        long right = 1000000000;

//        System.out.println("기존: "+ Z);

        while(left <= right){
            long mid = (left + right) / 2 ;
            long newZ = (long)Math.floor(((Y+mid) * 100) / (X+mid));

//            System.out.println(newZ);
            if(newZ >= Z+1){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        if(left > 1000000000){
            System.out.println(-1);
            return;
        }
        System.out.println(left);
    }
}
