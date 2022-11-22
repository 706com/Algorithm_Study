package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int n = N;
        int m = M;
        int r = 1;
        while(r!=0){
            r = N % M;
            N = M;
            M = r;
        }
        System.out.println(N);

        n = n / N;
        m = m / N;
        System.out.println(N*n*m);

    }
}