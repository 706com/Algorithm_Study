package 백준;

//새로 알게된 것
//LinkedList 방식으로 여러개의 값을 넣을 수 있다.
//1)LinkedList<int[]> q = new LinkedList<>();
//2)q.offer(new int[] { j , Integer.parseInt(st.nextToken())});

//테스트 케이스 과정이 끝날때마다 큐를 비워주는 작업이 필요하다.
//offer(),poll(),peek()[],get()[]

//다시 풀어보기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class _1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //T 값 : 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        LinkedList<int[]> q = new LinkedList<>();

        //테스트케이스 T번 반복
        for(int i=0; i<T; i++){

            int max = 0; //가장 큰 중요도
            int cnt =1;  //몇 번째로 출력되었는지

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //문서의 개수
            int M = Integer.parseInt(st.nextToken());   //몇 번째로 인쇄되었는지 궁금한 문서

            st = new StringTokenizer(br.readLine());

            //큐에다가 연결리스트 형식으로 문서의 순서 + 중요도 넣기
            //넣는김에 들어가는 문서 중 중요도 가장 큰 것 까지 찾아서 max에 넣어주기
            for(int j=0; j<N; j++){
                q.offer(new int[] { j , Integer.parseInt(st.nextToken())});
                if(max < q.get(j)[1]){
                    max = q.get(j)[1];
                }
            }

            // while문 조건
            // 1)픽한 문서 중요도가 가장 커야하며(max)
            // 2)현재 가장 앞에 있는 문서가 선택한 문서여야함(M)
            while((q.peek()[1] != max) || (q.peek()[0] != M)) {

                if (q.peek()[1] == max) { //만약 지금 문서가 가장 높은거면 없애버리고 cnt 증가
                    q.poll();
                    cnt++;

                    //중요도 가장 큰 문서가 없어졌으니, 남은문서 중 max값 찾기
                    max = 0;
                    for (int j = 0; j < q.size(); j++) {
                        if (max < q.get(j)[1]) {
                            max = q.get(j)[1];
                        }
                    }
                }
                //가장 앞에있는 문서의 중요도가 max값과 같거나 작으면
                else if(q.peek()[1] <= max){
                    q.offer(q.poll());  //뒤로 보내기
                }
            }
            System.out.println(cnt);


            //큐에 남아있는 값 모두 제거하는 과정(중요!)
            while(!q.isEmpty()) {
                q.poll();
            }
        }
    }
}

/*
//1번째 실패코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //T 값 : 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<T; i++){
            int max=0;
            int importance;
            int cnt=1;

            StringTokenizer st= new StringTokenizer(br.readLine());
            //st 첫번째(N) : 문서의 갯수 , st 두번째 : 몇 번째 문서 선택할거니?
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int pick_importance=0;

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j<M; j++){
                importance = Integer.parseInt(st2.nextToken());
                q.offer(importance);

                if(max < importance){
                    max= importance;
                }
                if(j==M){
                    pick_importance = importance;
                }
            }
            System.out.println("max 중요도 : "+ max);
            System.out.println("몇 번째 픽 할꺼야? : "+ M);
            System.out.println("픽한 번째의 중요도: "+ pick_importance);
            while(pick_importance != max){ //&& q.peek() != max)

                q.offer(q.poll());

                if(q.peek()==max){
                    q.poll();
                    cnt++;
                    for(int z=0; z<q.size(); z++){
                        max = 0;
                        if(max < q.peek()){
                            max= q.peek();
                        }
                        q.offer(q.poll());
                    }
                }
            }

            System.out.println("몇 번째 출력인가? : "+ cnt );


            //잘 들어 갔는지 확인
            for(int k= 0; k<q.size(); k++){
                System.out.print(q.poll()+" ");
            }

        }


    }
}

 */




