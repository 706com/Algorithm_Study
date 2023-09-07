package 알고리즘;

// 부분수열
// 그 수열 원소를 다 더한값
// {1,2} == {2,1}
// 조합 (순서상관 x) (중복? 모르겠음)


import java.util.Scanner;

public class Combination {
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

        for(int i=1;i<=N;i++){
            combination(0,0,i);
        }

    }
    static void combination(int depth,int start,int r){
        if(depth==r){
            for(int i=0; i<depth; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth+1,i+1,r);
                visited[i] = false;
            }
        }
    }
}
