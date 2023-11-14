package BOJ._2_Silver;

//[백준]1676 : 팩토리얼 0의 개수 - JAVA(자바)

//<새로 알게된 것>
// 누가봐도 overflow 발생할 것 같은 문제.
// 이런 문제는 직감살 어떤 규칙이 있겠구나라고 생각하면 더욱 좋다.

//<궁금한 것>
// 이 수학적 도출을 어떻게 해내지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1676_팩토리얼_0의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        //수학적으로 접근 2*5 소인수분해. 규칙성을 보다보면 결국 5^? 승 중, ? 의 값을 도출해내면 된다.
        while(num>=5){
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);

    }

}
