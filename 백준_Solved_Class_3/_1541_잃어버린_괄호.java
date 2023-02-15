package 백준_Solved_Class_3;
//[백준]1541: 잃어버린 괄호 - JAVA(자바)

//<새로 알게된 것>
//st.hasMoreTokens() : == isEmpty()

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusTokens = new StringTokenizer(br.readLine(),"-");

        int result = Integer.MAX_VALUE;

        while(minusTokens.hasMoreTokens()){
            int add = 0;

            StringTokenizer plusTokens = new StringTokenizer(minusTokens.nextToken(),"+");

            while(plusTokens.hasMoreTokens()){
                add += Integer.parseInt(plusTokens.nextToken());
            }

            //초깃값 세팅 (마이너스를 안만날경우 result 는 항상 MAX_VALUE이다.) ex) 10+20+30+40
            if(result == Integer.MAX_VALUE){
                result = add;
            }

            //마이너스가 하나라도 있을 때
            else if(result != Integer.MAX_VALUE && add != 0){
                result -= add;
            }

        }
        System.out.println(result);
    }
}
