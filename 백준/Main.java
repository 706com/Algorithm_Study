package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int min = 0;
        int mid = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }


        while(min < max){
            //System.out.print(min +" " + mid + " " + max);
            //System.out.println();
            mid = (min + max) / 2;
            long sum = 0;

            for(int height : arr){
                if(height - mid > 0){
                    sum += (height - mid);
                }
            }


            if(sum >= M){
                min = mid + 1;
            }
            else if(sum < M){
                max = mid;
            }
        }

        //System.out.print(min +" " + mid + " " + max);
        //System.out.println();
        System.out.println(min -1);



    }
}



//카드 2
//package 백준;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        Queue<Integer> q = new LinkedList<>();
//
//        for(int i=1; i<=N; i++){
//            q.offer(i);
//        }
//
//        while(q.size() != 1){
//            q.poll();
//            q.offer(q.poll());
//        }
//
//        System.out.println(q.peek());
//
//
//
//    }
//}
