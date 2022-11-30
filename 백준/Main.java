package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T != 0){
            T--;
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // 0번지부터 시작하니까 +1 해줘서
            // k층 n호 맞춰주기!
            int[][] arr = new int[k+1][n+1];

            //0층 사람 넣어주기 (0번지는 없다고 생각하고 1~n호)
            for(int i=0; i<n+1; i++){
                arr[0][i] = i;
            }

            // 마찬가지로 0층 , 0호는 없다고 생각하고,
            // 1층 1호부터 사람 넣어주기

            // i = 층
            // j = 호
            for(int i=1; i <= k; i++){
                for(int j=1; j <= n; j++){
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }

            System.out.println(arr[k][n]);
        }
    }
}




