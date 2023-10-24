package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1220_Magnetic {
    static int[][] arr;
    static boolean[][] visited;

    static int N;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        while(count<=10) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visited = new boolean[N][N];
            result = 0;

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        if(arr[i][j] == 1)
                            down(i,j);
//						if(arr[i][j] == 2) {
//							up(i,j);
//						}
                    }
                }
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
    static void down(int x,int y) {
        visited[x][y] = true;
        for(int i=x+1; i<N; i++) {
            if(arr[i][y] == 1 && !visited[i][y]) {
                visited[i][y] = true;
            }
            if(arr[i][y] == 2 && !visited[i][y]) {
                visited[i][y] = true;
                result++;
                return;
            }
            if(i == N-1) {
                return;
            }
        }
    }

//	static void up(int x,int y) {
////		System.out.println("들어왔 "+x+" "+y);
//		visited[x][y] = true;
//		for(int i=x-1; i>=0; i--) {
//			if(arr[i][y] == 2 && visited[i][y]) {
//				continue;
//			}
//			if(arr[i][y] == 1 && !visited[i][y]) {
//				visited[i][y] = true;
//				result++;
//				return;
//			}
//			if(i == 0) {
//				return;
//			}
//		}
//	}
}
