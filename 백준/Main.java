package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = func4(N);
        System.out.println(result);
    }

    static int func4(int N){
        int num =1;
        while(num<=N){
            num *=2;
        }
        return num/2;
    }

}