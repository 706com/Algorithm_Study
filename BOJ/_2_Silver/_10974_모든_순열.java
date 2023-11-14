package BOJ._2_Silver;

// < 알고리즘 유형 >
// 브루트포스(순열)

// < 풀이 접근 >
// *. 순열 (중복 x) but (순서 o)
// *. 시간복잡도 O(N!) 8이하의 정수이므로 통과
// 1. permutation을 구현하여 답을 구한다.


import java.util.Scanner;

public class _10974_모든_순열 {
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
