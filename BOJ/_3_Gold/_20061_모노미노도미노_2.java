package BOJ._3_Gold;

//[250119]

//좌표이동을 하나씩 하는건 말이 안되니.. 누적합 같은 문제?

import java.io.*;
import java.util.*;

public class _20061_모노미노도미노_2 {
    static boolean[][] blueArr;
    static boolean[][] greenArr;
    static int A = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        blueArr = new boolean[4][6];
        greenArr = new boolean[6][4];

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());   // 1,2,3
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stackBlue(t,x,y);
            evaluateBlue();
//            evaluateLightBlue();
            stackGreen(t,x,y);
//            evaluateLightGreen();
        }
    }
    public static void stackBlue(int t, int x, int y){
        // 1*1
        if(t==1){
            for(int i=1; i<=A; i++){
                if(i==A || blueArr[x][i]){
                   blueArr[x][i-1] = true;
                   break;
                }
            }
        }
        // 1*2 (가로)
        else if(t==2){
            for(int i=1; i<=A; i++){
                if(i==A || blueArr[x][i]){
                    blueArr[x][i-1] = true;
                    blueArr[x][i-2] = true;
                    break;
                }
            }
        }
        // 2*1 (세로)
        else{
            for(int i=1; i<=A; i++){
                if(i==A || (blueArr[x][i] || blueArr[x+1][i]) ){
                    blueArr[x][i-1] = true;
                    blueArr[x+1][i-1] = true;
                    break;
                }
            }
        }
        for(boolean[] a : blueArr){
            System.out.println(Arrays.toString(a)+" ");
        }
        System.out.println();
    }

    public static void evaluateBlue(){
        List<Integer> list = new ArrayList<>(); //줄 기억하기
        for(int i=2; i<=5; i++){
            boolean flagTrue = true;
            for(int j=0; j<4; j++){
                if(!blueArr[j][i]){
                    flagTrue = false;
                    break;
                }
            }
            //한 줄 깨짐 (이동해야함)
            if(flagTrue){
                list.add(i);
            }
        }
        if(!list.isEmpty()){
            moveBlue(list);
        }
    }
    public static void moveBlue(List<Integer> list){
        for(int line : list){
            for(int i=line; i>0; i--){
//                while()
            }
        }
    }

    public static void stackGreen(int t, int x, int y){
        // 1*1
        if(t==1){
            for(int i=1; i<=A; i++){
                if(i==A || greenArr[i][y]){
                    greenArr[i-1][y] = true;
                    break;
                }
            }
        }
        // 1*2 (가로)
        else if(t==2){
            for(int i=1; i<=A; i++){
                if(i==A || greenArr[i][y] || greenArr[i][y+1]){
                    greenArr[i-1][y] = true;
                    greenArr[i-1][y+1] = true;
                    break;
                }
            }
        }
        // 2*1 (세로)
        else{
            for(int i=1; i<=A; i++){
                if(i==A || greenArr[i][y]){
                    greenArr[i-1][y] = true;
                    greenArr[i-2][y] = true;
                    break;
                }
            }
        }
        for(boolean[] a : greenArr){
            System.out.println(Arrays.toString(a)+" ");
        }
        System.out.println();
    }
    public static class Node{
        String color;
        int x;
        int y;
        boolean isExist;
        Node(String color,int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public void exist(){
            this.isExist = true;
        }
        public void notExist(){
            this.isExist = false;
        }
    }
}
