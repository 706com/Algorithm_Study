package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr= new long[N];
        boolean check;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] arr2= new long[M];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<M; i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

        for(int i=0; i<N; i++){
            System.out.print(arr[i]+" ");
        }



        for(int i=0; i<M; i++){
            check=false;
            for(int j=0; j<N; j++){
                if(arr2[i] == arr[j]){
                    System.out.println("1");
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("0");
            }
        }

    }
}