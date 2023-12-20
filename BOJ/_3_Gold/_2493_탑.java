package BOJ._3_Gold;

//소요시간 : x 답 봄
//소요시간 : 27분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> stk = new Stack<Node>();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            Node node = new Node(i,Integer.parseInt(st.nextToken()));

            if(!stk.isEmpty() && stk.peek().num < node.num){
                while(stk.peek().num < node.num) {
                    stk.pop();
                    if(stk.isEmpty()){
                        break;
                    }
                }
            }

            if(stk.isEmpty()){
                arr[i] = 0;
                stk.push(node);
                continue;
            }

            if(stk.peek().num >= node.num){
                arr[i] = stk.peek().index;
                stk.push(node);
            }
        }

        for(int i=1; i<=N; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static public class Node{
        int index;
        int num;
        Node(int index, int num){
            this.index = index;
            this.num = num;
        }
    }
}
