package 백준;
//[백준]2839 : 달팽이는 올라가고 싶다 - JAVA(자바)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2869_달팽이는_올라가고_싶다 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int snail = 0;
        int day = 0;


//        while(snail < V){
//            cnt++;
//            snail += A;
//            if(snail >= V){
//                break;
//            }
//            snail -= B;
//        }
        day = (V-B) / (A-B);
        if((V-B) % (A-B) == 0){
            System.out.println(day);
        }
        else{
            System.out.println(day++);
        }

    }
}
