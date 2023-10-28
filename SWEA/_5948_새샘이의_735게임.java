package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5948_새샘이의_735게임 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[] arr = new int[7];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<5;i++) {
                for(int j=i+1; j<6; j++) {
                    for(int k=j+1; k<7; k++) {
                        int sum = arr[i] + arr[j] + arr[k];
                        pq.offer(sum);
                    }
                }
            }
            int cnt = 1;
            int num = pq.poll();
            while(cnt != 5) {
                if(pq.peek() == num) {
                    pq.poll();
                }
                else {
                    num = pq.poll();
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n",count,num);
            count++;
        }
    }
}
