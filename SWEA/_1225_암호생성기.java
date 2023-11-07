package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count = 1;

        while(count<=T){
            count = Integer.parseInt(br.readLine());
            int N = 8;
            Deque<Integer> deq = new LinkedList<>();

            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                deq.offerLast(Integer.parseInt(st.nextToken()));
            }

            int i = 1;
            while(deq.peekLast()!=0){
                int num = deq.pollFirst()-i;
                if(num<0){
                    num = 0;
                }
                deq.offerLast(num);
                i++;
                if(i==6){
                    i=1;
                }
            }

            System.out.printf("#%d ",count);
            for(int a=0; a<8; a++) {
                System.out.print(deq.pollFirst() + " ");
            }
            System.out.println();
            count++;
        }
    }
}
