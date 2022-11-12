//2292 : 벌집

//새로 알게된 것
//규칙 찾기 , 초기화 기준 생각하기
package 백준;

import java.util.Scanner;

public class _2292_벌집 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int range = 2;

        if(N==1){
            System.out.println("1");
        }
        else{
            while(range <= N) {
                range = range + (6 * count);
                count ++ ;
            }
            System.out.println(count);
        }

    }
}
