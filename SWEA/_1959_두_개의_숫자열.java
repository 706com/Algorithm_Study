package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1959_두_개의_숫자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B.add(Integer.parseInt(st.nextToken()));
            }

            for(int i=0; i<=Math.abs(N-M); i++){
                int num = 0;

                for(int j=0; j<Math.min(B.size(),A.size()); j++) {
                    num += (A.get(j) * B.get(j));
                }
                if(num>max){
                    max = num;
                }

                if(A.size()<B.size()){
                    A.add(0,0);
                }
                else if(A.size()>B.size()){
                    B.add(0,0);
                }
            }
            System.out.printf("#%d %d",count,max);
            System.out.println();
            count++;
        }
    }
}
