package 백준;
//[백준]2839 : 달팽이는 올라가고 싶다 - JAVA(자바)

//<새로 알게된 것>
//시간제한 0.15초
//시간이 짧을때는 반복문은 절대 들어가면 안되고, 수식으로 풀어야한다.
//수식 고민하기
//point : 정상에 올라간 후에는 미끄러지지 않는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2869_달팽이는_올라가고_싶다 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = 0;

        day = (V-B) / (A-B);    //몫 = day

        //밤이 되기 전(V-B) ,
        //(V-B) % (V-A)
        // 나머지가 없으면(0이면) 등반 성공
        //나머지가 있으면 한번 더 올라야 함
        if((V-B) % (A-B) != 0){
            day++;
        }

        System.out.println(day);

    }
}

//        while(snail < V){
//            cnt++;
//            snail += A;
//            if(snail >= V){
//                break;
//            }
//            snail -= B;
//        }
