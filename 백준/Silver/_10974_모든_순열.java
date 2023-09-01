package 백준.Silver;

// < 알고리즘 유형 >
// 브루트포스(순열)

// < 풀이 접근 >
// 1. permutation을 구현하여 답을 구한다.
// 시간복잡도 O(N!) 8이하의 정수이므로 통과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974_모든_순열 {

    static int[] arr;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        output = new int[n];
        visited = new boolean[n];

        for(int i=1; i<=n; i++){
            arr[i-1] = i;
        }

        permutation(0,n,n);
    }

    public static void permutation(int depth, int n, int r){
        if(depth == r){
            for(int i=0; i< output.length; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth+1,n,r);
                visited[i] = false;
            }
        }
    }
}
