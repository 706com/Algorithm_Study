package BOJ._4_Platinum;

//소요시간 : 30분 (실패) : 구현아예 못함
//소요시간 : 13분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11003_최솟값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> deq = new LinkedList<>();

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            Node node = new Node(i,arr[i]);

            //Queue 안에 들어올 노드보다 큰 값이 있으면 다 빼내기
            //최솟값만 찾는 것이기 때문에, 큰 값은 무의미
            if(!deq.isEmpty() && deq.peekLast().num >= node.num){
                while(true){
                    deq.pollLast();
                    if(deq.isEmpty() || deq.peekLast().num < node.num){
                        break;
                    }
                }
            }
            deq.offer(node);
            //앞에 노드 인덱스가 범위에서 벗어나면 poll
            if(deq.peekFirst().index <= i-L){
                deq.pollFirst();
            }

            sb.append(deq.peekFirst().num).append(" ");
        }
        System.out.println(sb);
    }
    static class Node{
        int index;
        int num;
        Node(int index, int num){
            this.index = index;
            this.num = num;
        }
    }
}

