package BOJ._2_Silver;
//[백준]1026 : 보물 - JAVA(자바)

//소요시간 : 17분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[N];
        Integer[] arr2 = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2,Collections.reverseOrder());

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += arr1[i] * arr2[i];
        }
        System.out.println(sum);
    }
}
