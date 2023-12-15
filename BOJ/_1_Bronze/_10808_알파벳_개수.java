package BOJ._1_Bronze;

//소요시간 : 5분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10808_알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];

        for(int i=0; i<str.length(); i++){
            int index = (str.charAt(i)-'0') - 49;
            arr[index]++;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
