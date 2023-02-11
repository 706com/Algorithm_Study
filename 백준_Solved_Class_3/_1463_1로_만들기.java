package 백준_Solved_Class_3;
//[백준]1463 : 1로 만들기 - JAVA(자바)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463_1로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //1 <=N<= 10^6

        int count = 0;
        while(N!=1){
            count++;
            if(N % 3 == 0) {
                N /= 3;
                continue;
            }
            else if(N % 2 == 0) {
                N /= 2;
                continue;
            }
            N -= 1;
        }
        System.out.println(count);
    }
}
