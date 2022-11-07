/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int a = 0;
        while(a != cnt) {
            int num = sc.nextInt();
            fibonacci(num);
            System.out.println( cntzero + " " + cntone);
            cntzero=0;
            cntone=0;
            a++;
        }
    }
    static int cntzero = 0;
    static int cntone = 0;
    public static int fibonacci(int n){


        if(n==0) {
            //System.out.println("0");
            cntzero++;
            return 0;
        }
        else if( n== 1){
            //System.out.println("1");
            cntone++;
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int cnt = Integer.parseInt(br.readLine());

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int a = 0;

        while(a != cnt) {
            //int num = Integer.parseInt(br.readLine());
            int num = sc.nextInt();
            fibonacci(num);
            System.out.println( dp[num][0] + " " + dp[num][1]);
            a++;
        }

    }
    static Integer[] fibonacci(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }

        return dp[n];
    }
}
*/
/*
//블랙잭
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(black(arr,m));


    }

    public static int black(int[] arr,int m){
        int temp = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                for(int k=2; k<arr.length; k++){
                    if(temp <= (arr[i]+arr[j]+arr[k]) && m >= (arr[i]+arr[j]+arr[k])){
                        temp = arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }
        return temp;
    }
}
*/ //블랙잭



/*
//1018 : 체스판 다시 칠하기
import java.util.Scanner;

public class Main{
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str= sc.next();

            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'W'){
                    arr[i][j] = true;
                }
                else
                    arr[i][j] = false;
            }
        }

        int N_row = N-7;
        int M_col = M-7;

        for()
    }
}

 */ //1018 : 체스판 다시 칠하기

