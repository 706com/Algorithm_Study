package 프로그래머스.Lv2;

//소요시간
//[240515] : 20분

import java.util.*;

public class 무인도_여행 {

    static boolean[][] visited;
    static int[][] arr;
    static int N,M;
    static Queue<Node> q = new LinkedList<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public int[] solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();
        arr = new int[N][M];
        visited = new boolean[N][M];

        List<Integer> list = new ArrayList<>();

        // map 재생성
        for(int i=0; i<N; i++){
            String str = maps[i];
            for(int j=0; j<M; j++){
                char c = str.charAt(j);
                if(c == 'X'){
                    arr[i][j] = -1;
                } else{
                    arr[i][j] = Integer.valueOf(c-'0');
                }
            }
        }

        // 검증
        // System.out.println(Arrays.deepToString(arr));

        // bfs 순회 및 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j] >= 1){
                    int num = bfs(i,j);
                    list.add(num);
                }
            }
        }
        // System.out.println(list);

        //무인도가 없다면 -1을 배열에 담아 return
        if(list.size() == 0){
            return new int[]{-1};
        }

        //최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    int bfs(int x, int y){
        int days = arr[x][y];
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(visited[nx][ny] || arr[nx][ny] == -1){
                    continue;
                }
                q.offer(new Node(nx,ny));
                visited[nx][ny] = true;
                days += arr[nx][ny];
            }
        }
        return days;
    }
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
