package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _6808_규영이와_인영이의_카드게임 {

    static GY gy;
    static int[] arr;	//규영이 카드
    static int[] output = new int[9];	// 경우의수 배열
    static boolean[] visited = new boolean[9];	//방문여부

    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            win = 0;
            lose = 0;

            gy = new GY();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++) {
                gy.card[i] = Integer.parseInt(st.nextToken());
            }
            // 리스트 정렬 후에 인영이의 카드가 뭐가 필요한지 식별.
            ArrayList<Integer> number = new ArrayList<>();
            for(int i=0; i<9; i++) {
                number.add(gy.card[i]);
            }
            Collections.sort(number);

            // 인영이 카드 : 규영이가 가지고 있지 않은것
            arr = new int[9];
            int index = 0;
            for(int i=1; i<=18; i++) {
                if(!number.contains(i)) {
                    arr[index] = i;
                    index++;
                }
            }
            //인영이 카드 순열 돌리기
            permutation(0);

            System.out.printf("#%d %d %d\n",count,win,lose);
            count++;
        }
    }

    static void permutation(int depth) {
        if(depth == 9) {
            gy.init();

            //인영이 카드 경우의 수 생성 및 결과 비교
            IY iy = new IY();
            iy.card = output;

            //규영 vs 인영 점수 비교 및 더하기
            for(int i=0; i<9; i++) {
                if(gy.card[i] > iy.card[i]) {
                    gy.score += gy.card[i] + iy.card[i];
                }
                else if(gy.card[i] < iy.card[i]) {
                    iy.score += gy.card[i] + iy.card[i];
                }
            }
            //규영vs인영 최종 스코어 비교 후 승패결정
            if(gy.score > iy.score) {
                win++;
            }
            else if(gy.score < iy.score) {
                lose++;
            }
            return;
        }
        //순열돌리기
        for(int i=0; i<9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth+1);

                visited[i] = false;

            }
        }
    }

    //규영
    static class GY {
        int[] card = new int[9];
        int score = 0;

        public void init() {
            score = 0;
        }
    }
    //인영
    static class IY {
        int[] card = new int[9];
        int score = 0;

        public void addScore(int sum) {
            score += sum;
        }
    }

}


