package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] arr = new long[M];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //이분탐색
        Arrays.sort(A);

//        for(int i=0; i<N; i++){
//            System.out.print(A[i] + " ");
//        }
//        System.out.println();
//
//        for(int i=0; i<N; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        int low,mid,high;

        boolean check = false;

        for(int i=0; i<arr.length; i++) {
            long key = arr[i];

            low = 0;
            mid = 0;
            high = A.length -1;
            check = false;

            while(low <= high) {
                mid = (low + high) / 2;

                if(key == A[mid]){
                    check = true;
                    break;
                }
                else if (key < A[mid]){
                    high = mid-1;
                }
                else if(key > A[mid]){
                    low = mid+1;
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