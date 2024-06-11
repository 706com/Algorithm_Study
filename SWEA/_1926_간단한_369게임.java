package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _1926_간단한_369게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            int cnt = 0;
            boolean check = false;
            String str = String.valueOf(i);

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)!='0' && str.charAt(j) % 3 == 0){
                    check = true;
                    cnt++;
                }
            }
            if(!check){
                System.out.print(i);
            }
            else{
                for(int j=0; j<cnt; j++){
                    System.out.print("-");
                }
            }
            System.out.print(" ");
        }
    }
}
