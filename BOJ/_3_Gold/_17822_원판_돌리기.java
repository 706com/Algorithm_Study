package BOJ._3_Gold;

//[241229] 1시간 40분

import java.io.*;
import java.util.*;

public class _17822_원판_돌리기 {
    static int N,M,T;
    static int x,d,k;
    static boolean isChanged;
    static int countZero =0;
    static Node[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //원판 개수
        M = Integer.parseInt(st.nextToken());   //M개의 정수
        T = Integer.parseInt(st.nextToken());   //T번

        arr = new Node[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = new Node(i,j,Integer.parseInt(st.nextToken()));
            }
        }
//        printArr();

        // 변수는 xi, di, ki이다
        // 번호가 xi의 배수인 원판을 di방향으로 ki칸 회전
        // di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            isChanged = false;
            countZero = 0;

            if(d==0){
                rotate();
            } else{
                rotateReverse();
            }
//            printArr();
            checkErase();
//            printArr();
            if(!isChanged){
                changeNum();
            }
//            printArr();
        }
        System.out.println(sumArr());
    }
    //시계방향
    public static void rotate(){
        Deque<Node> q = new LinkedList<>();
        //움직이는 수가 M이랑 똑같으면 제자리
        if(k==M){
            return;
        }
        //X번째 원판 k칸 회전
        for(int i=x-1; i<N; i+=x){
            for(int j=0; j<M; j++){
                q.offer(arr[i][j]);
            }
            for(int j=0; j<k; j++){
                q.offerFirst(q.pollLast());
            }
            for(int j=0; j<M; j++){
                arr[i][j] = q.pollFirst();
            }
        }
    }
    //반시계방향
    // ==========
    // 3 1 3 5
    // 5 3 1 3
    // ==========
    public static void rotateReverse(){
        Deque<Node> q = new LinkedList<>();
        //움직이는 수가 M이랑 똑같으면 제자리
        if(k==M){
            return;
        }
        //X번째 원판 k칸 회전
        for(int i=x-1; i<N; i+=x){
            for(int j=0; j<M; j++){
                q.offer(arr[i][j]);
            }
            for(int j=0; j<k; j++){
                q.offerLast(q.pollFirst());
            }
            for(int j=0; j<M; j++){
                arr[i][j] = q.pollFirst();
            }
        }
    }
    public static void printArr(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j].num+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int sumArr(){
        int sum = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j].num == 0){
                    countZero++;
                }
                sum += arr[i][j].num;
            }
        }
        return sum;
    }
    public static void checkErase() {
        //가로 체크
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j].num == 0 || arr[i][(j+1)%M].num == 0){
                    continue;
                }
                if(arr[i][j].num == arr[i][(j+1)%M].num){
                    arr[i][j].isSame = true;
                    arr[i][(j+1)%M].isSame = true;
                    isChanged = true;
                }
            }
        }

        //세로 체크
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                // 세로는 4 != 1
                if(j==N-1){
                    break;
                }
                if(arr[j][i].num == 0 || arr[(j+1)%N][i].num == 0){
                    continue;
                }
                if(arr[j][i].num == arr[(j+1)%N][i].num){
                    arr[j][i].isSame = true;
                    arr[(j+1)%N][i].isSame = true;
                    isChanged = true;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j].isSame){
                    arr[i][j].num = 0;
                }
            }
        }
    }
    public static void changeNum() {
        double avg = (double)sumArr() / ((N*M) - countZero);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j].num == 0){
                    continue;
                }
                if(arr[i][j].num<avg){
                    arr[i][j].num +=1;
                }
                else if(arr[i][j].num>avg){
                    arr[i][j].num -=1;
                }
            }
        }
    }
    static class Node{
        int i;
        int j;
        int num;
        boolean isSame;
        Node(int i, int j, int num){
            this.i = i;
            this.j = j;
            this.num = num;
            this.isSame = false;
        }
        public void isSame(){
            this.isSame = true;
        }
    }
}
