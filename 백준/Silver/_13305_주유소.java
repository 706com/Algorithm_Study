package 백준.Silver;
//[백준]13305 : 주유소 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디 , 구현 , 수학

//< 알고리즘 풀이 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.*;
import java.util.StringTokenizer;

public class _13305_주유소 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N-1];
        long[] cost = new long[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<cost.length; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long mincost = cost[0];
        long sum = 0;

        for(int i=0; i< N-1; i++){
            if(mincost > cost[i]){
                mincost=cost[i];
            }

            sum += mincost * dist[i];
        }

        System.out.println(sum);
    }
}
