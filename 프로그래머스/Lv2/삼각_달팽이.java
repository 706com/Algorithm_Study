package 프로그래머스.Lv2;

//[250301] 🔍

import java.util.*;

public class 삼각_달팽이 {
    // 하 우 좌상
    int[] dx = {0,1,-1};
    int[] dy = {1,0,-1};
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int nx = 0;
        int ny = 0;

        arr[nx][ny] = 1;
        int num = 2;

        int count = n;
        //n번 만큼 순회하면 break;
        while(count>0){
            for(int i=0; i<3; i++){

                // n번 만큼 순회
                count--;
                while(true){
                    nx += dx[i];
                    ny += dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=n){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if(arr[ny][nx] != 0){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    arr[ny][nx] = num;
                    num++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // System.out.print(arr[i][j]+" ");
                if(arr[i][j] != 0){
                    list.add(arr[i][j]);
                }
            }
            System.out.println();
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
