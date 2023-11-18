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

            String tempS = "";
            String tempT = "";
            while(tempS.length()<=100){
                tempS+=S;
            }
            tempS= tempS.substring(0,100);
            while(tempT.length()<=100){
                tempT+=T;
            }
            tempT= tempT.substring(0,100);
//            System.out.println(tempS);
//            System.out.println(tempT);

            if(tempT.equals(tempS)){
                result = "yes";
            }
            else{
                result = "no";
            }

            System.out.printf("#%d %s\n",count,result);
            count++;
        }
    }
}
