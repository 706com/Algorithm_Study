package SWEA;

// 15분 소요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15758_무한_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=t){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken();
            String result = "";

            if(S.length()>=T.length()){
                if(S.indexOf(T)==0){
                    while(T.length()<=100){
                        T+=T;
                    }
                    S+=S;
                    if(T.indexOf(S)==0) {
                        result = "yes";
                    }
                    else{
                        result = "no";
                    }
                }
                else{
                    result = "no";
                }
            }
            else{
                if(T.indexOf(S)==0){
                    while(S.length()<=100){
                        S+=S;
                    }
                    T+=T;
                    if(S.indexOf(T)==0) {
                        result = "yes";
                    }
                    else{
                        result = "no";
                    }
                }
                else{
                    result = "no";
                }
            }

            System.out.printf("#%d %s\n",count,result);
            count++;
        }
    }
}
