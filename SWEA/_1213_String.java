package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1213_String {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =10;

        while(T-->0){
            int count = Integer.parseInt(br.readLine());

            String insert = br.readLine();
            String str = br.readLine();

            int result = 0;

            while(str.contains(insert)){
                if(str.contains(insert)){
                    str = str.substring(str.indexOf(insert) + insert.length()-1 , str.length());
                    result++;
                }
            }

            System.out.printf("#%d %d",count, result);
            System.out.println();
        }
    }

}
