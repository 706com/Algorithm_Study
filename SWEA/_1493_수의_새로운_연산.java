package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1493_수의_새로운_연산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 1;
            int num = 1;
            while(N-->0) {
                if(y==1) {
                    x= 1;
                    y=num;
                    num++;
                    continue;
                }
                x++;
                y--;
            }

            int xx = 0;
            int yy = 1;
            int num2 = 1;
            while(M-->0) {
                if(yy==1) {
                    xx= 1;
                    yy=num2;
                    num2++;
                    continue;
                }
                xx++;
                yy--;
            }

            int resultX = x+ xx;
            int resultY = y+ yy;

            int[][] arr = new int[resultY+2][resultX+2];

            arr[1][1] = 1;
            for(int i=1; i<=resultY; i++) {
                arr[i+1][1] = arr[i][1]+i;
            }

            for(int i=1; i<=resultY; i++) {
                for(int j=1; j<resultX; j++) {
                    arr[i][j+1] = arr[i][j]+i+j;
                }
            }

            System.out.printf("#%d %d\n",count,arr[resultY][resultX]);
            count++;
        }
    }
}
