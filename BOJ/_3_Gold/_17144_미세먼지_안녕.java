package BOJ._3_Gold;

//[241217] 3시간

import java.util.*;
import java.io.*;

public class _17144_미세먼지_안녕 {

    static int R,C,T;
    static int[][] arr;
    static long result = 0L;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Node> airCondition = new ArrayList<>();

    public static class Node{
        int x;
        int y;
        int amount;

        Node(int x, int y,int amount){
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());   //행
        C = Integer.parseInt(st.nextToken());   //열
        T = Integer.parseInt(st.nextToken());   //초

        arr = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1){
                    airCondition.add(new Node(i,j,arr[i][j]));
                }
            }
        }

        while(T-->0){
            spread();
            airOperate();
//            System.out.println();
        }
        sum();
        System.out.println(result+2);
    }
    // 미세먼지가 확산된다
    // (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산
    // 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
    // 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
    // (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
    public static void spread(){
        // (확산을 위해) 미세먼지 양이 5이상인 것만 체크
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] >= 5){
                    q.offer(new Node(i,j,arr[i][j]));
                }
            }
        }

        // 확산된 정보 담기
        int count = q.size();
        while(count>0){
           Node node = q.poll();
           for(int i=0; i<4; i++){
               int nx = node.x + dx[i];
               int ny = node.y + dy[i];

               if(nx<0 || nx>=R || ny<0 || ny>=C){
                   continue;
               }
               if(arr[nx][ny] == -1){
                   continue;
               }
               int separate = node.amount / 5;
               arr[node.x][node.y] -= separate;
               q.offer(new Node(nx,ny,separate));
           }
           count--;
        }

        // 확산은 동시에 일어나야함
        while(!q.isEmpty()){
            Node node = q.poll();
            arr[node.x][node.y] += node.amount;
        }

        // 확산 출력 검증
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    // 공기청정기에서는 바람이 나온다.
    // 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
    // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    // 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
    public static void airOperate(){
        upperSpread();  // 위쪽 -> 반시계 순환
        lowerSpread();  // 아래쪽 -> 시계 순환
    }

    // 반시계 방향
    public static void upperSpread(){
        Node node = airCondition.get(0);

        // 하 이동
        for(int i = node.x; i > 0 ; i--) {
            arr[i][0] = arr[i-1][0];
        }
        arr[node.x][node.y] = 0; // 미세먼지에서 나오는 0 밀어내기 위해;
        // 좌 이동
        for(int i=0; i<C-1; i++){
            arr[0][i] = arr[0][i+1];
        }
        // 상 이동
        for(int i=0; i<node.x; i++){
            arr[i][C-1] = arr[i+1][C-1];
        }
        // 우 이동
//        System.out.println(arr[node.x][node.y]);
        for(int i=C-1; i>0; i--){
            arr[node.x][i] = arr[node.x][i-1];
        }
        arr[node.x][node.y] = -1;

//        System.out.println("상단 부분");
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    // 시계 방향
    public static void lowerSpread(){
        Node node = airCondition.get(1);

        // 상 이동
        for(int i=node.x; i<R-1; i++){
            arr[i][0] = arr[i+1][0];
        }
        arr[node.x][node.y] = 0; // 미세먼지에서 나오는 0 밀어내기 위해;
        // 좌 이동
        for(int i=0; i<C-1; i++){
            arr[R-1][i] = arr[R-1][i+1];
        }
        // 하 이동
        for(int i=R-1; i > node.x-1 ; i--) {
            arr[i][C-1] = arr[i-1][C-1];
        }
        // 우 이동
        for(int i=C-1; i>0; i--){
            arr[node.x][i] = arr[node.x][i-1];
        }
        arr[node.x][node.y] = -1;

//        System.out.println("하단 부분");
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    public static void sum(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                result += arr[i][j];
            }
        }
    }
}
