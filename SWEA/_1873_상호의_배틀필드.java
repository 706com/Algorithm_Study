package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _1873_상호의_배틀필드 {

    static int H,W;
    static char[][] arr;
    static int x,y;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new char[H][W];

            // 맵 입력 및 전차 시작점 저장
            for(int i=0; i<H; i++){
                String str = br.readLine();
                for(int j=0; j<W; j++){
                    char c = str.charAt(j);
                    arr[i][j] = c;
                    if(c=='<' || c=='>' || c=='^' || c=='v'){
                        y= i;
                        x= j;
                    }
                }
            }
            //맵 확인
//            for(int i=0; i<H; i++){
//                for(int j=0; j<W; j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();
            for(int i=0; i<N; i++){
                char c = command.charAt(i);

                switch (c){
                    case('U'):
                        moveUp();
                        break;
                    case('D'):
                        moveDown();
                        break;
                    case('L'):
                        moveLeft();
                        break;
                    case('R'):
                        moveRight();
                        break;
                    case('S'):
                        shoot();
                        break;
                }
//                // 커맨드 입력 후 반응 보기
//                for(int o=0; o<H; o++){
//                    for(int j=0; j<W; j++){
//                        System.out.print(arr[o][j]+" ");
//                    }
//                    System.out.println();
//                }
            }

            System.out.printf("#%d ",count);
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    System.out.print(arr[i][j]+"");
                }
                System.out.println();
            }
            count++;
        }
    }

    public static void moveUp(){
        // 전차 방향 먼저 돌리기
        arr[y][x] = '^';

        // 범위 벗어나면 return
        if(y-1<0)
            return;

        //전차 이동 할 곳이 평지(.) 라면 현재 전차위치를 평지(.) 로 바꾸고 이동
        if(arr[y-1][x] == '.'){
            arr[y][x] = '.';
            arr[y-1][x] = '^';
            y = y-1;
        }
    }
    public static void moveDown(){
        arr[y][x] = 'v';

        if(y+1>=H)
            return;
        if(arr[y+1][x] == '.'){
            arr[y][x] = '.';
            arr[y+1][x] = 'v';
            y = y+1;
        }
    }
    public static void moveLeft(){
        arr[y][x] = '<';

        if(x-1<0)
            return;

        if(arr[y][x-1] == '.'){
            arr[y][x] = '.';
            arr[y][x-1] = '<';
            x = x-1;
        }
    }
    public static void moveRight(){
        arr[y][x] = '>';

        if(x+1>=W)
            return;

        if(arr[y][x+1] == '.'){
            arr[y][x] = '.';
            arr[y][x+1] = '>';
            x = x+1;
        }
    }


    public static void shoot(){
        //우
        if(arr[y][x] == '>'){
            for(int i=x; i<W; i++){
                //벽돌 : 깨지고 평지로 바뀜
                if(arr[y][i] == '*'){
                    arr[y][i] = '.';
                    return;
                }
                //강철 : 아무일 없지만 stop
                else if(arr[y][i] == '#'){
                    return;
                }
            }
        }
        //좌
        else if(arr[y][x] == '<'){
            for(int i=x; i>=0; i--){
                //벽돌 : 깨지고 평지로 바뀜
                if(arr[y][i] == '*'){
                    arr[y][i] = '.';
                    return;
                }
                //강철 : 아무일 없지만 stop
                else if(arr[y][i] == '#'){
                    return;
                }
            }
        }
        //상
        else if(arr[y][x] == '^'){
            for(int i=y; i>=0; i--){
                //벽돌 : 깨지고 평지로 바뀜
                if(arr[i][x] == '*'){
                    arr[i][x] = '.';
                    return;
                }
                //강철 : 아무일 없지만 stop
                else if(arr[i][x] == '#'){
                    return;
                }
            }
        }
        //하
        else if(arr[y][x] == 'v'){
            for(int i=y; i<H; i++){
                //벽돌 : 깨지고 평지로 바뀜
                if(arr[i][x] == '*'){
                    arr[i][x] = '.';
                    return;
                }
                //강철 : 아무일 없지만 stop
                else if(arr[i][x] == '#'){
                    return;
                }
            }
        }
    }

}
