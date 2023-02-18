package 백준_Solved_Class_3;
//[백준]1697 : 숨바꼭질 - JAVA(자바)

//<새로 알게된 것>

//<궁금한 것>


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;

public class _1697_숨바꼭질 {
    static int N,K;
    static Queue<Integer> q;
    static int[] dist;
    static int[] dx = {-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


    }
}
