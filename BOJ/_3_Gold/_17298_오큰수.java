package BOJ._3_Gold;

//소요시간 : 40분
// 반례
// 4 3 2 1 2 3 4
// 9 8 8 10
// 9 8 8 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        Stack<Node> stk = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            Node node = new Node(i,num);

            //스택이 비어있거나, 스택 상단노드가 현재노드보다 크거나 *같으면*
            if(stk.isEmpty() || stk.peek().num >= node.num){
               stk.push(node);
            }
            else{
                // 현재노드가 스택상단보다 더 클 때
                // 스택이 비어지거나, 크거나 같아질경우 stop 
                while(true) {
                    Node popNode = stk.pop();
                    result[popNode.index] = node.num;

                    if(stk.isEmpty() || stk.peek().num >= node.num){
                        break;
                    }
                }
                //pop이 끝나면 현재노드 넣기
                stk.push(node);
            }
        }

        for(int i=0; i<N; i++){
            if(result[i] == 0){
                sb.append("-1").append(" ");
                continue;
            }
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
    static class Node{
        int index;
        int num;
        Node(int index,int num){
            this.index = index;
            this.num = num;
        }
    }
}
