package 백준_Solved_Class_3;
//[백준]2667 : 단지번호붙이기 - JAVA(자바)

//< 나의 알고리즘 >
// bfs !

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2667_단지번호붙이기 {
    static int N;
    static int[][] board;
    static boolean[][] visit;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 5 ≤ N ≤ 25

        board = new int[N][N];
        visit = new boolean[N][N];

        List<Integer> list = new ArrayList<>();

        //입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                board[i][j] = Character.getNumericValue(c);
            }
        }

        int estateCount = 0;    //단지 개수
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 0 || visit[i][j] == true){
                    continue;
                }
                int result = homeNumbering(i,j);
                estateCount++;
                list.add(result);
            }
        }

        //오름차순 정렬
        Collections.sort(list);

        //단지 개수 출력
        System.out.println(estateCount);

        //단지내 집 개수 출력
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static int homeNumbering(int x, int y){
        q.offer(new Node(x,y));
        visit[x][y] = true;

        int houseCount = 1;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] == true || board[nx][ny] == 0) {
                    continue;
                }
                q.offer(new Node(nx, ny));
                visit[nx][ny] = true;
                houseCount ++;
            }
        }
        return houseCount;
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
