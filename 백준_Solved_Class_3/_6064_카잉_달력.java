package 백준_Solved_Class_3;
//[백준]6064 : 카잉 달력 - JAVA(자바)

//< 나의 알고리즘 >

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6064_카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            //입력
            st = new StringTokenizer(br.readLine()," ");

            int M = Integer.parseInt(st.nextToken());   //1 ≤ M, N ≤ 40,000
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());   //1 ≤ x ≤ M
            int y = Integer.parseInt(st.nextToken());   //1 ≤ y ≤ N

            int i=0;
            int j=0;
            int count =0;
            boolean check = false;
            while((i!=M || j!=N)) {
                if(i==x && j==y){
                    check = true;
                    break;
                }
                if(i>M){
                    i=1;
                }
                if(j>N){
                    j=1;
                }
                System.out.println("<" + i + ":" + j + ">");
                i++;
                j++;
                count++;
            }
            System.out.println("<" + i + ":" + j + ">");
            if(!check){
                System.out.println("-1");
            }
            else {
                System.out.println(count);
            }
        }
    }
}
