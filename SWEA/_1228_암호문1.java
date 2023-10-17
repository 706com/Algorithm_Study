package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

// < 풀이 접근 >
// *. 사이에 끼워넣기가 잦기때문에 (맺고끊음) LinkedList 를 구현하여 시간을 단축한다.
// 1. I를 기준으로 잘라내는 StringTokenizer 를 생성한다
// 2. " " 띄어쓰기를 기준으로 잘라내는 StringTokenizer 를 생성한다.
// 3. 인덱스를 기준으로 list 에 끼워넣어 정답 생성.

public class _1228_암호문1 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count = 1;

        while(count <=T){
            int N = Integer.parseInt(br.readLine()); // 원본 암호문 길이 N
            // *. 사이에 끼워넣기가 잦기때문에 (맺고끊음) LinkedList 를 구현하여 시간을 단축한다.
            List<Integer> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            int M = Integer.parseInt(br.readLine());
            // 1. I를 기준으로 잘라내는 StringTokenizer 를 생성한다
            st = new StringTokenizer(br.readLine(),"I");
            for(int i=0; i<M; i++){
                String str = st.nextToken();
//                System.out.println(str);

                // 2. " " 띄어쓰기를 기준으로 잘라내는 StringTokenizer 를 생성한다.
                StringTokenizer st2 = new StringTokenizer(str," ");

                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                for(int j=0; j<y; j++){
                    int s = Integer.parseInt(st2.nextToken());
                    // 3. 인덱스를 기준으로 list 에 끼워넣어 정답 생성.
                    list.add(x+j,s);
                }
            }

            System.out.printf("#%d ",count);
            for(int i=0; i<10; i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            count++;

        }
    }
}
