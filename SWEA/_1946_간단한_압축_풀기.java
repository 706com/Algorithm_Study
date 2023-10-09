package SWEA;

// < 알고리즘 유형 >
// 단순 구현

// < 풀이 접근 >
// 1. class Node 를 받는 ArrayList 를 선언한다.
// 2. Node 안에는 문자와 값을 입력받는다.
// 3. node 안에 있는 num 을 하나씩 줄여나가, 0이 되는 시점에 배열에서 삭제시킨다.
// 4. 배열안에 아무 node 도 없을시에 while 문을 탈출한다.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class _1946_간단한_압축_풀기 {

    static int test = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            int N = Integer.parseInt(br.readLine());
            // 1. class Node 를 받는 ArrayList 를 선언한다.
            ArrayList<Node> arr = new ArrayList<>();

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String c = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // 2. Node 안에는 문자와 값을 입력받는다.
                arr.add(new Node(c,num));
            }

            System.out.printf("#%d\n",test);

            while(true){
                // 3. node 안에 있는 num 을 하나씩 줄여나가,
                // 0이 되는 시점에 배열에서 삭제시킨다.
                for(int j=0; j<10; j++){

                    System.out.printf("%s",arr.get(0).c);
                    arr.get(0).num--;

                    if(arr.get(0).num == 0){
                        arr.remove(0);
                    }

                    // 4. 배열안에 아무 node 도 없을시에 while 문을 탈출한다.
                    if(arr.size() == 0){
                        break;
                    }
                }
                System.out.println();
                // 4. 배열안에 아무 node 도 없을시에 while 문을 탈출한다.
                if(arr.size() == 0){
                    break;
                }
            }
            test++;
        }
    }
    static class Node{
        String c;
        int num;

        Node(String c, int num){
            this.c = c;
            this.num = num;
        }
    }
}
