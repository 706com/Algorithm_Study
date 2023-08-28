package 백준.Silver;
//[백준]2839 : 설탕배달 - JAVA(자바)

import java.util.Scanner;

//<새로 알게된 것>
//수학적 사고 -> 규칙찾기
public class _2839_설탕배달 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int result = sugar(N);
            System.out.println(result);

    }

    public static int sugar(int n){

        //5의배수
        if(n % 5 == 0) {
            return (n / 5);
        }
        //5의배수 +1
        else if((n % 5) == 1){
            return (n / 5) + 1;
        }
        //5의배수 +2 (12보다 클 때부터 해당)
        else if((n % 5) == 2 && n >= 12){
            return (n / 5) + 2;
        }
        //5의 배수 +3
        else if((n % 5) == 3 ){
            return (n / 5) + 1;
        }
        //5의배수 +4   (9보다 클 때부터 해당)
        else if((n % 5) == 4 && n >= 9){
            return (n / 5) + 2;
        }
        // 4,7 일 때
        else{
            return -1;
        }
    }
}
