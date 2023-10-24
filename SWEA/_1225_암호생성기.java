package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1225_암호생성기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10; //문제오류
        int count=1;

        while(count<10) {
            count = Integer.parseInt(br.readLine());

            Deque<Integer> deq = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<8; i++) {
                deq.offerLast(Integer.parseInt(st.nextToken()));
            }

            int cnt =1;
            while(deq.peekLast()!=0) {
                int num = deq.pollFirst();

                if(num-cnt>=0) {
                    num = num-cnt;
                }
                else {
                    num = 0;
                }
                cnt++;
                if(cnt==6) {
                    cnt=1;
                }
                deq.offerLast(num);
            }
//			System.out.println(deq.toString());

            System.out.printf("#%d ",count);
            for(int i=0; i<8; i++) {
                System.out.print(deq.pollFirst()+" ");
            }
            System.out.println();

        }
    }
}
