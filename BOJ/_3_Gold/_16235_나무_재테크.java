package BOJ._3_Gold;

//[241216] 시간초과 -> 자료구조 변경으로 해결 (2시간)

import java.util.*;
import java.io.*;

public class _16235_나무_재테크 {
    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }
        public int compareTo(Tree o){
            return age - o.age;
        }
    }

    static int N,M,K;
    static int[][] energy;
    static int[][] currentGroundEnergy;
    static PriorityQueue<Tree> tree;    // List -> PQ로 변경
    static Queue<Tree> deadTree; // List -> Queue로 변경

    static int[] dx = {0,0,-1,1,-1,-1,1,1};   //상 하 좌 우 좌상 좌하 우상 우하
    static int[] dy = {-1,1,0,0,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 땅 크기
        M = Integer.parseInt(st.nextToken());   // 심은 나무 개수
        K = Integer.parseInt(st.nextToken());   // K년 후

        energy = new int[N+1][N+1];
        currentGroundEnergy = new int[N+1][N+1];

        tree = new PriorityQueue<>();
        deadTree = new LinkedList<>();

        // 기본 양분 5부터 시작
        for(int i=1; i<=N; i++){
            Arrays.fill(currentGroundEnergy[i],5);
        }

        // 겨울에 쓰일 양분 정보 저장
        for(int i=1; i<=N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                energy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 나무 심기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            tree.add(new Tree(x,y,age));
        }

        for(int i=0; i<K; i++){
            seasonSpring();
            seasonSummer();
            seasonAutumn();
            seasonWinter();
        }
        System.out.println(tree.size());
    }

    // - 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가
    // - 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다
    // - 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
    public static void seasonSpring() {
        Queue<Tree> temp = new LinkedList<>();

        while(!tree.isEmpty()){
            Tree t = tree.poll();
            if(currentGroundEnergy[t.x][t.y] >= t.age){
                currentGroundEnergy[t.x][t.y] -= t.age;
                t.age += 1;
                temp.offer(t);
            } else{
                deadTree.offer(t);
            }
        }

        for(Tree x : temp){
            tree.add(x);
        }
    }

    // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
    // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
    public static void seasonSummer() {
        while(!deadTree.isEmpty()){
            Tree t = deadTree.poll();
            currentGroundEnergy[t.x][t.y] += (t.age / 2);
        }
    }

    // 가을에는 나무가 번식한다.
    // 번식하는 나무는 나이가 5의 배수이어야 하며
    // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    public static void seasonAutumn() {
        List<Tree> temp = new ArrayList<>();
        for(Tree x : tree){
            if(x.age % 5 == 0){
                for(int i=0; i<8; i++){
                    int nx = x.x + dx[i];
                    int ny = x.y + dy[i];

                    if(nx<=0 || ny<=0 || nx>N || ny>N){
                        continue;
                    }
                    temp.add(new Tree(nx,ny,1));
                }
            }
        }
        for(Tree x : temp){
            tree.add(x);
        }
    }

    // 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가
    // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
    public static void seasonWinter() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                currentGroundEnergy[i][j] += energy[i][j];
            }
        }
    }
}
