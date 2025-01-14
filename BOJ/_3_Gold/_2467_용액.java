package BOJ._3_Gold;

//[250115]

import java.io.*;
import java.util.*;

public class _2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;

        int resultLeft = 0;
        int resultRight = N-1;

        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            if(left == right){
                break;
            }
            if(Math.abs(arr[left]+arr[right]) < min){
                min = Math.min(min, Math.abs(arr[left]+ arr[right]));
                resultLeft = left;
                resultRight = right;
            }
            // 음수
            if(arr[left]+arr[right] < 0){
                left++;
            }
            // 양수
            else if(arr[left]+arr[right] > 0){
                right--;
            }
            //0이 되면 종료
            else {
                break;
            }
        }
        System.out.println(arr[resultLeft]+" "+arr[resultRight]);
    }
}
