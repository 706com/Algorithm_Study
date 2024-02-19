package BOJ._2_Silver;
//[백준]1541 : 잃어버린 괄호 - JAVA(자바)

//소요시간 : 30M

// Integer.MAX_VALUE 로 초기화 해준 이유 ->

/*
<만약 temp가 첫 번째, 두 번째, 세 번째 때 모두 23이 들어온다고 가정>
그럼 처음 값으로는 23이니 sum = 23
그 다음에는 if 조건절을 만족하지 않으니, sum -= temp에 의해 0이 될 것이다.
그 다음이 문제. 만약 sum == 0을 조건절로 걸게 되면 sum=temp; 에 의해 sum은 23이 되어버려 잘못된 값을 갖게 된다.
원래는 sum -= temp에 의해 -23 이 되어야 하는게 정상.

그래서 많은 문제들의 초기값은 중간 계산 혹은 결과로 나오지 않는 수로 초기화 해주는게 일반적인 방식이다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str,"-");

        int result = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
            int temp = 0;
            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken());
            }

            //맨 처음이라는 뜻 == 맨 처음 초기화
            if(result == Integer.MAX_VALUE){
                result = temp;
            }
            else{
                result -= temp;
            }
        }
        System.out.println(result);
    }
}
