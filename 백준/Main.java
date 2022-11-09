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
        Scanner sc= new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] arr= new boolean[N+1];

        arr[0] = true;
        arr[1] = true;

        for(int i=2; i<Math.sqrt(arr.length); i++){
            if(arr[i]){
                continue;
            }
            for(int j = i*i; j<arr.length; j+=i){
                arr[j] = true;
            }
        }

        for(int i=M; i<arr.length; i++){
            if(!arr[i]){
                System.out.println(i);
            }
        }


    }
}