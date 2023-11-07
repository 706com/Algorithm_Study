package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1215_회문1 {
    static int len;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int count = 1;

        while(count<=T){
            len = Integer.parseInt(br.readLine());
            result = 0;
            int N = 8;
            char[][] arr = new char[N][N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            //가로
            for(int i=0; i<N; i++){
                search(arr[i]);
            }
            //세로
            char[] newArr = new char[N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                search(newArr);
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
    public static void search(char[] arr){
        for(int i=0; i<=8-len; i++){
            boolean check = true;
            int start = i;
            int end = i+len-1;

            for(int j=0; j<=len/2; j++) {
                if (arr[start] != arr[end]) {
                    check = false;
                    break;
                }
                start++;
                end--;
            }

            if(check){
                result++;
            }
        }
    }
}

