package 문제해결력연습;

// < 알고리즘 유형 >
// 스택

// < 풀이 접근 >
// 1. 스택 2개를 구현한다. (leftStk , rightStk)
// 2. 문자열이 들어오는대로 left Stack에 넣는다.
// 3. '<' 가 들어오면, 들어온 수 만큼 leftStack 에 있는 값을 rightStack 에 옮긴다.
// 4. '>' 가 들어오면, 들어온 수 만큼 rightStack에 있는 값을 leftStack에 옮긴다.
// 5. 모든 값을 right Stack에 옮기고 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class _1954_달팽이_숫자 {

    static int N;
    static int dir = 0;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1};   // 하 상
    static int[] dy = {1,0,-1,0};   // 우 좌

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            dir = 0;

            dfs(0,0);

            System.out.printf("#%d\n",count);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            count++;
        }


    }
    static void dfs(int x, int y){


        for(int i=1; i<=N*N; i++){



            arr[x][y] = i;
            visited[x][y] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];


            if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] == true){
                dir = (dir + 1) % 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];

        }
    }
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}

