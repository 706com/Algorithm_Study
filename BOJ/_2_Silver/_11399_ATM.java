package BOJ._2_Silver;
//[백준]11399 : ATM - JAVA(자바)

//소요시간 : 5분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        int result = 0;
        for(int x : arr){
            sum += x;   //해당 사람이 기다린 시간
            result += sum;  //총 인출시간
        }
        System.out.println(result);
    }
}
