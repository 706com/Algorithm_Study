package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫번째 배열 넣기
        int N = Integer.parseInt(br.readLine());
        long[] arr= new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }


        //두번째 배열 넣기
        int M = Integer.parseInt(br.readLine());
        long[] arr2= new long[M];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<M; i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        //이분 탐색 시작
        Arrays.sort(arr);

        int low,high,mid;
        boolean check;


        for(int i=0; i<arr2.length; i++) {
            long key = arr2[i];

            check = false;
            low = 0;
            high = arr.length-1;

            while (low <= high) {
                mid = (low + high) / 2;

                if (key == arr[mid]) {
                    check = true;
                    break;
                }
                else if (key > arr[mid]) {
                    low = mid + 1;
                }
                else if (key < arr[mid]) {
                    high = mid-1;
                }
            }
            if(check){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }



    }
}