package BOJ._3_Gold;

//[250119] 3시간🔍

import java.io.*;
import java.util.*;

public class _20061_모노미노도미노_2 {
    static boolean[][] blueArr;
    static boolean[][] greenArr;
    static int A = 6;
    static int score = 0;
    static int tile = 0;
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
            evaluateLightBlue();

            stackGreen(t,x,y);
            evaluateGreen();
            evaluateLightGreen();
        }

        countTile();
        System.out.println(score);
        System.out.println(tile);
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
//        for(boolean[] a : blueArr){
//            System.out.println(Arrays.toString(a)+" ");
//        }
//        System.out.println();
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
    public static void evaluateLightBlue(){
        List<Integer> list = new ArrayList<>(); //줄 기억하기
        for(int i=0; i<=1; i++){
            boolean flagTrue = false;
            for(int j=0; j<4; j++){
                if(blueArr[j][i]){
                    flagTrue = true;
                    break;
                }
            }
            //하나라도 있으면
            if(flagTrue){
                list.add(i);
            }
        }
        if(!list.isEmpty()){
            moveBlue(list);
        }
    }

    //밀어내기 (점수획득, 단순 밀어냄)
    public static void moveBlue(List<Integer> list){
//        System.out.println(list);
        Collections.sort(list);
        for (Integer line : list) {
            if (line >= 2) { // 2~5인 경우 (점수 증가)
                for (int j = line; j > 0; j--) {
                    for (int i = 0; i < 4; i++) {
                        blueArr[i][j] = blueArr[i][j - 1];
                    }
                }
                for (int i = 0; i < 4; i++) {
                    blueArr[i][0] = false;
                }
                score++;
            } else { // 0~1인 경우 (단순 밀어내기)
                for (int j = 5; j > 0; j--) {
                    for (int i = 0; i < 4; i++) {
                        blueArr[i][j] = blueArr[i][j - 1];
                    }
                }
                for (int i = 0; i < 4; i++) {
                    blueArr[i][0] = false;
                }
            }
        }
//        System.out.println("=========밀어내기==========");
//        for(boolean[] a : blueArr){
//            System.out.println(Arrays.toString(a)+" ");
//        }
//        System.out.println();
    }

    //그린 쌓기
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
//        for(boolean[] a : greenArr){
//            System.out.println(Arrays.toString(a)+" ");
//        }
//        System.out.println();
    }

    public static void evaluateGreen(){
        List<Integer> list = new ArrayList<>(); //줄 기억하기
        for(int i=2; i<=5; i++){
            boolean flagTrue = true;
            for(int j=0; j<4; j++){
                if(!greenArr[i][j]){
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
            moveGreen(list);
        }
    }
    public static void evaluateLightGreen(){
        List<Integer> list = new ArrayList<>(); //줄 기억하기
        for(int i=0; i<=1; i++){
            boolean flagTrue = false;
            for(int j=0; j<4; j++){
                if(greenArr[i][j]){
                    flagTrue = true;
                    break;
                }
            }
            //하나라도 있으면
            if(flagTrue){
                list.add(i);
            }
        }
        if(!list.isEmpty()){
            moveGreen(list);
        }
    }
    public static void moveGreen(List<Integer> list){
//        System.out.println(list);
        Collections.sort(list);

        for (Integer line : list) {
            if (line >= 2) { // 2~5인 경우
                for (int i = line; i > 0; i--) {
                    for (int j = 0; j < 4; j++) {
                        greenArr[i][j] = greenArr[i - 1][j];
                    }
                }
                for (int j = 0; j < 4; j++) {
                    greenArr[0][j] = false;
                }
                score++;
            } else {
                for (int i = 5; i > 0; i--) {
                    for (int j = 0; j < 4; j++) {
                        greenArr[i][j] = greenArr[i - 1][j];
                    }
                }
                for (int j = 0; j < 4; j++) {
                    greenArr[0][j] = false;
                }
            }
        }
//        System.out.println("=========밀어내기==========");
//        for(boolean[] a : greenArr){
//            System.out.println(Arrays.toString(a)+" ");
//        }
//        System.out.println();
    }
    public static void countTile(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (blueArr[i][j]) {
                    tile++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (greenArr[i][j]) {
                    tile++;
                }
            }
        }
    }
}
