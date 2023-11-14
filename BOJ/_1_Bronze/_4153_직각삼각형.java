package BOJ._1_Bronze;
//[백준]4153 : 직각삼각형 - JAVA(자바)

//<새로 알게된 것>
//제곱 : Math,pow(5,2) = 5^2
//피타고라스 정리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if(a==0 && b==0 && c==0){
                break;
            }

            //피타고라스 정리
            if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(c,2)){
                System.out.println("right");
            }
            else if(Math.pow(b,2)+Math.pow(c,2)==Math.pow(a,2)){
                System.out.println("right");
            }
            else if(Math.pow(a,2)+Math.pow(c,2)==Math.pow(b,2)){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
        }
    }
}
