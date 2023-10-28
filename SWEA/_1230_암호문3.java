package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1230_암호문3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        while(count<=10) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int index;
            int len;
            for(int i=0; i<M; i++) {
                String command = st.nextToken();
                switch (command) {
                    case "I":
                        index = Integer.parseInt(st.nextToken());
                        len = Integer.parseInt(st.nextToken());
                        for(int j=0; j<len; j++) {
                            list.add(index+j, st.nextToken());
                        }
                        break;
                    case "D":
                        index = Integer.parseInt(st.nextToken());
                        len = Integer.parseInt(st.nextToken());
                        for(int j=0; j<len; j++) {
                            list.remove(index);
                        }
                        break;
                    case "A":
                        len = Integer.parseInt(st.nextToken());
                        for(int j=0; j<len; j++) {
                            list.offerLast(st.nextToken());
                        }
                        break;
                }
            }
            System.out.printf("#%d ",count);
            for(int i=0; i<10; i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            count++;
        }

    }

}
