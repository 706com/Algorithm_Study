package BOJ._3_Gold;

//[250311] 🔍

import java.io.*;
import java.util.*;

public class _1339_단어_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        System.out.println(Character.getNumericValue('Z')-10);  // 해당 결과값이 0 나옴

        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha,0);

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                alpha[Character.getNumericValue(c)-10] += (int)Math.pow(10,str.length()-1-j);   //3번째 자리면 100
//                System.out.println(alpha[Character.getNumericValue(c)-10]);
            }
        }
//        System.out.println(Arrays.toString(alpha));

        Arrays.sort(alpha,Collections.reverseOrder()); //내림차순 정렬

        // 9 부터 순차배정
        int num = 9;
        int result = 0;
        for(int i=0; i<alpha.length; i++){
            // 0이된건 배정받지 못한 알파벳
            if(alpha[i] == 0){
                break;
            }
            result += alpha[i] * num;
            num--;
        }
        System.out.println(result);
    }
}
