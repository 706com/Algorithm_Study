package BOJ._1_Bronze;

//소요시간 : 12분 -> 더 쉽게 가능..!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10807_개수_세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] minusArr = new int[101];
        int[] plusArr = new int[101];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 음수 = 음수배열 저장
            if(num<0){
                num = Math.abs(num);
                minusArr[num]++;
            }
            // 0,양수 = 양수배열 저장
            else{
                plusArr[num]++;
            }
        }

        int result = Integer.parseInt(br.readLine());
        if(result<0){
            result = Math.abs(result);
            System.out.println(minusArr[result]);
        }
        else{
            System.out.println(plusArr[result]);
        }
    }
}
