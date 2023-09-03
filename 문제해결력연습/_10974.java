package 문제해결력연습;

//사전순 출력
//순열 (중복x ) but (순서 o)
// O(n!)

import java.util.Scanner;

public class _10974 {
    static int N;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        permutation(0);
    }
    static void permutation(int depth){
        if(depth==N){
            for(int i=0; i<depth; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }
}
