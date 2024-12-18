package BOJ.fail;

//[241218] 실패

import java.io.*;
import java.util.*;

public class _17143_낚시왕 {
    static int result = 0;
    static int nowCol = 0;
    static int R,C,M;
    static Shark[][] arr;
    static Queue<Shark> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   //행
        C = Integer.parseInt(st.nextToken());   //열
        M = Integer.parseInt(st.nextToken());   //상어 수

        arr= new Shark[R+1][C+1];

        //상어 정보
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z);
            arr[r][c] = shark;
        }

//        printArr();

        while(nowCol<C){
            moveFisher();
            catchShark();
            moveShark();
            eatEachOther();
//            System.out.println();
//            printArr();
//            System.out.print(result);
        }
        System.out.println(result);
    }
    static void moveFisher(){
        nowCol++;
    }
    static void catchShark(){
        for(int i=1; i<=R; i++){
            if(arr[i][nowCol] == null){
                continue;
            }
            result += arr[i][nowCol].z;
            arr[i][nowCol] = null;
            break;
        }
    }

    // 이 부분에서 최적화 필요할 듯 (1000만이라 괜찮을까?)
    // r,c,s,d와 행,열 크기와 비교해서..?
    // 옮긴 후에, 어디다가 담아둬야 할까?
    //  -> q에 한 번 담고 빼는 작업으로 해보자
    static void moveShark(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(arr[i][j] == null){
                    continue;
                }
                //현재 상어 추출
                Shark shark = arr[i][j];

                //하 기준
                if(shark.d == 2) {
                    int distance = shark.r + shark.s;   //총 이동거리
                    int division = distance / R;    //몫
                    int remaining = distance % R;   //나머지
                    int finalDistance = remaining + division;   //최종 결정된 거리
                    if(finalDistance > R){
                        division += (finalDistance / R);
                        finalDistance %= R;
                    }

                    // 짝 : 이동 방향 그대로
                    // 상부터 시작
                    if(division % 2 == 0){
                        shark.r = 0 + finalDistance;
                    }
                    // 홀 : 이동 방향 변경
                    // 하부터 시작
                    else{
                        shark.d = 1;
                        shark.r = Math.abs(R+1 - finalDistance);
                    }
                }
                //상 기준
                else if(shark.d == 1) {
                    int distance = Math.abs(R+1-shark.r) + shark.s;   //총 이동거리
                    int division = distance / R;    //몫
                    int remaining = distance % R;   //나머지
                    int finalDistance = remaining + division;   //최종 결정된 거리
                    if(finalDistance > R){
                        division += (finalDistance / R);
                        finalDistance %= R;
                    }

                    // 짝 : 이동 방향 그대로
                    // "하"부터 시작
                    if(division % 2 == 0){
                        shark.r = Math.abs(R+1 - finalDistance);
                    }
                    // 홀 : 이동 방향 변경
                    // 상부터 시작
                    else{
                        shark.d = 2;
                        shark.r = 0 + finalDistance;
                    }
                }

                //우 기준
                else if(shark.d == 3) {
                    int distance = shark.c + shark.s;   //총 이동거리
                    int division = distance / C;    //몫
                    int remaining = distance % C;   //나머지
                    int finalDistance = remaining + division;   //최종 결정된 거리
                    if(finalDistance > C){
                        division += (finalDistance / C);
                        finalDistance %= C;
                    }

                    // 짝 : 이동 방향 그대로
                    // "좌"부터 시작
                    if(division % 2 == 0){
                        shark.c = 0 + finalDistance;
                    }
                    // 홀 : 이동 방향 변경
                    // "우"부터 시작
                    else{
                        shark.d = 4;
                        shark.c = Math.abs(C+1 - finalDistance);
                    }
                }

                //좌 기준
                else if(shark.d == 4){
                    int distance = Math.abs(C+1-shark.c) + shark.s;   //총 이동거리
                    int division = distance / C;    //몫
                    int remaining = distance % C;   //나머지
                    int finalDistance = remaining + division;   //최종 결정된 거리
                    if(finalDistance > C){
                        division += (finalDistance / C);
                        finalDistance %= C;
                    }

                    // 짝 : 이동 방향 그대로
                    // "우"부터 시작
                    if(division % 2 == 0){
                        shark.c = Math.abs(C+1 - finalDistance);
                    }
                    // 홀 : 이동 방향 변경
                    // "좌"부터 시작
                    else{
                        shark.d = 3;
                        shark.c = 0 + finalDistance;
                    }
                }
                arr[i][j] = null;
                q.offer(shark);
            }
        }
    }

    static void eatEachOther(){
        while(!q.isEmpty()){
            Shark shark = q.poll();
//            if(shark.r > R){
//                while(shark.r > R) {
//                    shark.r /= R;
//                }
//            }
//            if(shark.c > C){
//                while(shark.c > C) {
//                    shark.c /= C;
//                }
//            }
            if(arr[shark.r][shark.c] == null){
                arr[shark.r][shark.c] = shark;
            } else{
                //새로 들어온 상어 크기가 더 크면 잡아먹기
                if(arr[shark.r][shark.c].z <= shark.z){
                    arr[shark.r][shark.c] = shark;
                }
            }
        }
    }

    static void printArr(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(arr[i][j] == null){
                    System.out.print("X ");
                } else {
                    System.out.print(arr[i][j].z + " ");
                }
            }
            System.out.println();
        }
    }
    static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        Shark(int r, int c, int s, int d, int z){
            this.r=r;
            this.c=c;
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
}
