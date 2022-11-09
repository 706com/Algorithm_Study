package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max<arr[i]){
                max = arr[i];
            }
        }

        boolean[] check = new boolean[max+1];
        check[0] = true;
        check[1] = true;

        for(int i=2; i<Math.sqrt(check.length); i++){
            if(check[i]){
                continue;
            }
            for(int j=i*i; j< check.length; j+=i){
                check[j] = true;
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(!check[arr[i]]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}