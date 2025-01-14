package BOJ._3_Gold;

//[250114] 27뷴

import java.io.*;
import java.util.*;

public class _2470_두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        // -99 -2 -1 4 98
        int min = Integer.MAX_VALUE;

        int maxLeft = 0;
        int maxRight = N-1;
        for(int i=0; i<N; i++){
            if(right == left){
                break;
            }
            if(Math.abs(arr[left] + arr[right]) < min){
                min = Math.min(min,Math.abs(arr[left]+arr[right]));
                maxLeft = left;
                maxRight = right;
            }
            //합이 양수면 right 이동
            if(arr[left] + arr[right] > 0){
                right--;
            }
            //합이 음수면 left 이동
            else if(arr[left] + arr[right] < 0) {
                left++;
            }
            // 0나오면 종료
            else{
                break;
            }
        }
        System.out.println(arr[maxLeft]+" "+arr[maxRight]);
    }
}
