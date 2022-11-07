package 백준;

//<새로 알게된 것>
//Collections.reverse(List)     :     안에 있는 내용 뒤집기
//Character.isAlphabetic(alpha) :  알파벳인지 판별
//char to String    : String.valueOf(char)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class _000_특정문자뒤집기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        ArrayList<String> arr= new ArrayList<String>();
        ArrayList<String> result = new ArrayList<>();


        //맨 처음 알파벳 판별 알고리즘
//        for(int i=0; i<N.length(); i++){
//            char alpha = N.charAt(i);
//            //System.out.println(alpha);
//            if(!(alpha >='A' && alpha <='Z') && !(alpha >= 'a' && alpha <= 'z')){
//                continue;
//            }
//            else{
//                arr.add(String.valueOf(alpha));
//;
//            }
//        }

        //1. String 형 내용을 하나하나 뽑아내기 charAt
        //2. 만약에 charAt 값이 알파벳이면 arr 리스트에 담기
        for(int i=0; i<N.length(); i++){
            char alpha = N.charAt(i);
            //System.out.println(alpha);
            if(Character.isAlphabetic(alpha)){
                arr.add(String.valueOf(alpha));
            }
        }

        //ArrayList 안에 담겨있는 내용 뒤집기
        Collections.reverse(arr);


        //다시 맨 처음 문자열 보면서
        //1. 만일 그 값이 알파벳이면 arr에 담겨있는 0번지값 뽑아내고 삭제 (result 리스트에 담기)
        //2. 알파벳이 아니면 그대로 출력
        for(int i=0; i<N.length(); i++){
            char c = N.charAt(i);
            if(Character.isAlphabetic(c)){
                result.add(arr.get(0));
                arr.remove(0);
            }
            else{
                result.add(String.valueOf(c));
            }
        }

        for(int i=0; i<result.size(); i++)
            System.out.print(result.get(i));
    }
}