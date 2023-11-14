//2292 : 벌집

//새로 알게된 것
//규칙 찾기 , 초기화 기준 생각하기
package BOJ._1_Bronze;

import java.util.Scanner;

public class _2292_벌집 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;  //방의 갯수는 1부터 1이다
        int range = 2;  //숫자가 2일때부터, 6의배수 범위가 해당이 된다.

        //1일때.
        if(N==1){
            System.out.println("1");
        }
        //2일때 (6의 배수 규칙)
        else{
            while(range <= N) {
                range = range + (6 * count);
                count ++ ;
            }
            System.out.println(count);
        }

    }
}
