package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1216_회문2 {
    static int max;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count = 1;

        while(count<=T){
            count = Integer.parseInt(br.readLine());
            max = 0;
            N = 100;
            Character[][] arr = new Character[N][N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            //가로 찾기
            for(int i=0; i<N; i++){
                search(arr[i]);
            }

            //세로 찾기
            for(int i=0; i<N; i++){
                Character[] newArr = new Character[N];
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                search(newArr);
            }

            System.out.printf("#%d %d\n",count,max);
            count++;
        }
    }

    static void search(Character[] arr){

        //1 3 5 7 9 단위
        for(int i=0; i<N; i++){
            int start = i;
            int sum = -1;
            for(int j=0; j<N; j++) {
                if (start-j >=0 && start+j < N) {
                    if (arr[start - j] == arr[start + j]) {
                        sum += 2;
                        max = Math.max(max, sum);
                    } else {
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }

        //2 4 6 8 10 단위
        for(int i=1; i<N; i++){
            int sum = 0;
            int start = i;
            int end = i+1;
            for(int j=0; j<N; j++) {
                if (start >=0 && end < N) {
                    if(arr[start] == arr[end]){
                        sum+=2;
                        max = Math.max(max,sum);
                    }
                    else{
                        break;
                    }
                    start--;
                    end++;
                }
                else{
                    break;
                }
            }
        }
    }
}
