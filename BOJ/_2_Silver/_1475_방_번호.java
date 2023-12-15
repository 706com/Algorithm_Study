package BOJ._2_Silver;

//소요 시간 : 9분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475_방_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[10];
        int max = 0;

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i)-'0';
            // 9 == 6 이라는 점을 이용하여, 6의 총 갯수 세어주기
            if(num == 9){
                num = 6;
            }
            arr[num]++;
        }

        // 6의 개수가 4가 되었을 경우(짝수) : 2개 필요
        // 6의 개수가 5가 되었을 경우(홀수) : 3개 필요
        if(arr[6] % 2 ==0){
            arr[6] /= 2;
        }
        else{
            arr[6] = (arr[6]/2) + 1;
        }

        // 가장 최댓값으로 필요 갯수 도출
        for(int i=0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        System.out.println(max);
    }
}
