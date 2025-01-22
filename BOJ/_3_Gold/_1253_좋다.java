package BOJ._3_Gold;

//[250122] 33분 (반례 확인)

import java.util.*;
import java.io.*;

public class _1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            int num = arr[i];
            int left = 0;
//            int right = i-1;
            int right = N-1;    //음수 고려하기

            while(left<right){
                //본인 제외하기
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }
                if(left>=right || right < 0 || left>=N){
                    break;
                }
//                System.out.println(left+" "+right);
                if(arr[left] + arr[right] == num){
//                    System.out.println("HIT : " + arr[left] + " "+arr[right]);
                    answer++;
                    break;
                }
                else if(arr[left]+arr[right] < num){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        System.out.println(answer);
    }
}
