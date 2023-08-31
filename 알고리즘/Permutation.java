package 알고리즘;

// 순열
// 순서 상관이 있는, 모든 경우의 수를 나열
// visited 와 dfs 를 활용해 모든 값을 구한다.

// <변수 의미>
// arr	    r 개를 뽑기 위한 n 개의 값
// output	뽑힌 r 개의 값
// visited	중복해서 뽑지 않기 위해 체크하는 값


// < 알고리즘 설명 >
// 1. DFS를 돌면서 모든 인덱스를 방문하여 output 에 값을 넣습니다.
// 2. 이미 들어간 값은 visited 값을 true 로 바꾸어 중복하여 넣지 않도록 합니다.
// 3. depth 값은 output 에 들어간 숫자의 길이라고 생각하시면 됩니다.
// 4. depth 의 값이 r 만큼 되면 output 에 들어있는 값을 출력하면 됩니다.

public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        int depth = 0;
        int[] arr = {1,2,3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        permutation(arr,output,visited,0,n,3);
    }

    static void permutation(int[] arr, int[] output,boolean[] visited, int depth, int n, int r){
        if(depth == r){
            for(int i=0; i<r; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr,output,visited,depth+1,n,r);
                visited[i] = false;
            }
        }
    }
}
