package 백준;

//1259 : 팰린드롬수
//새로 알게된 것
//charAt -> string(문자열) 타입을 char(낱개의 문자) 타입 으로 쪼개는 것
//next , readline 에 대해서 제대로 파악

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1259_팰린드롬수 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean check = true;

        //str의 내용이 0이 아닐때 에는 계속 반복
        while(true){
            int num = sc.nextInt();
            String str = Integer.toString(num);

            if(str.equals("0")){
                break;
            }
            //굳이 str의 내용 끝까지 돌 필요 없이 중간까지만 비교해주면 앞뒤 같은지 다른지 판별 가능
            //<= 가 필수이다.
            for(int i=0; i<=str.length()/2; i++){

                //charAt -> string(문자열) 타입을 char(낱개의 문자) 타입 으로 쪼개는 것
                if(str.charAt(i)==str.charAt(str.length()-i-1)){
                    check = true;
                }
                else{
                    check = false;
                    break;
                }
            }
            if(check)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}


//다시 푼 것
//package 백준;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.InputStreamReader;
//
//class Main{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        boolean check = false;
//
//        while(true){
//            String str = br.readLine();
//            if(str.equals("0")){
//                break;
//            }
//
//            for(int i = 0; i <= str.length()/2; i++){
//                if(str.charAt(i) == str.charAt(str.length()-i-1)){
//                    check = true;
//                }
//                else {
//                    check = false;
//                    break;
//                }
//            }
//            if(check)
//                System.out.println("yes");
//            else{
//                System.out.println("no");
//            }
//        }
//
//
//    }
//}


