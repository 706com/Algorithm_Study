package BOJ._2_Silver;

//[250822] 25분

import java.io.*;
import java.util.*;

public class _1431_시리얼_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        Collections.sort(list,(o1,o2)->{
            if(o1.length() == o2.length()){
                int o1Sum = 0;
                int o2Sum = 0;
//                System.out.println(o1);
                for(int i=0; i<o1.length(); i++){
                    char c = o1.charAt(i);
                    if(Character.isDigit(c)) {
                        o1Sum += Character.getNumericValue(o1.charAt(i));
                    }
                }
                for(int i=0; i<o2.length(); i++){
                    char c = o2.charAt(i);
                    if(Character.isDigit(c)){
                        o2Sum += Character.getNumericValue(o2.charAt(i));
                    }
                }
                if(o1Sum == o2Sum){
                    //숫자가 더 앞으로 와야댐
                    return o1.compareTo(o2);
                }
                return o1Sum - o2Sum;
            }
            return o1.length() - o2.length();
        });

//        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
