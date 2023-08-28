package 백준.Silver;
//[백준]2667 : 단지번호붙이기 - JAVA(자바)

//< 나의 알고리즘 >
// 최단경로 문제가 아니니 dfs(재귀)로 구현

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667_단지번호붙이기 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int dangi = 0;
    static int count;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        //단지내용 입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                int num = Character.getNumericValue(str.charAt(j));
                board[i][j] = num;
            }
        }

        //dfs 를 돌려서 단지수 , 단지내 집 수 알아내기

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 단지가 있고(1), 방문하지 않았으면 dfs돌기
                // dfs가 도는 갯수마다 단지 갯수 세기
                // list 에 단지내부를 쭉 돌면서 센 count 넣어주고 count 초기화
                if(board[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    dangi++;
                    arr.add(count);
                    count=0;
                }
            }
        }
        // 단지내 집 수 오름차순 정렬
        Collections.sort(arr);

        //출력
        System.out.println(dangi);

        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }
    static void dfs(int x,int y){
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N)
                continue;

            if(board[nx][ny] != 1 || visited[nx][ny])
                continue;

            dfs(nx,ny);
        }
    }
}
