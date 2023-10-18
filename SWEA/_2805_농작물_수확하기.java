package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2805_농작물_수확하기 {

    static int[][] arr;
    static int N;
    static int mid;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            N = Integer.parseInt(br.readLine());
            mid = N/2+1;
            arr = new int[N+1][N+1];

            for(int i=1; i<=N; i++){
                String str = br.readLine();
                for(int j=1; j<=N; j++){
                    char c = str.charAt(j-1);
                    arr[i][j] = Character.getNumericValue(c);
                    // Tip : c - '0'
                }
            }

//            for(int i=1; i<=N; i++){
//                for(int j=1; j<=N; j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }

            //상단 + 중간
            int result = 0;
            for(int i=1; i<=mid; i++){
                int sum = solveUp(i-1);
                result += sum;
            }

            //하단
            for(int i=mid+1; i<=N; i++){
                int sum = solveDown(N-i);
                result += sum;
            }
            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
    public static int solveUp(int i){
        int sum = 0;
        for(int j=mid-i; j<=mid+i; j++){
            sum += arr[i+1][j];
        }
        return sum;
    }

    public static int solveDown(int i){
        int sum = 0;
        for(int j=mid-i; j<=mid+i; j++){
            sum += arr[N-i][j];
        }
        return sum;
    }
}
