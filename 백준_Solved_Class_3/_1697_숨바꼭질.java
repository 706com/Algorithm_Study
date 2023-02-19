package 백준_Solved_Class_3;
//[백준]1697 : 숨바꼭질 - JAVA(자바)

//<새로 알게된 것>

//<궁금한 것>


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class _1697_숨바꼭질 {
    static int N,K;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[200000];

        Arrays.fill(dist,-1);

        int result = bfs(N);

        System.out.println(result);
    }
    public static int bfs(int n){
        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        q.offer(n);
        dist[n] = count;


        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.println("n = "+x + " ,count "+ count);
            count++;
            for (int i = 0; i < 3; i++) {
                int nx;
                //좌 or 우 1칸 이동 or *2 이동
                if(i==0){
                    nx = x + 1;
                }
                else if(i==1){
                    nx = x - 1;
                }
                else{
                    nx = x * 2;
                }

                if(nx == K){
                    dist[nx] = count;
                    return dist[nx];
                }
                if(n<0 || n>dist.length || dist[nx] != -1){
                    continue;
                }
                q.offer(nx);
                dist[nx] = count;
            }
        }

        return -1;
    }
    static class Node{
        int where;
        int dist;
        Node(int where, int dist){
            this.where = where;
            this.dist = dist;
        }
    }
}
