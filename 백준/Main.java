package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.offer(num);
            }
        }
    }
}