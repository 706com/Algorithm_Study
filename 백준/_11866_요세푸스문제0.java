package 백준;
//[백준]11651 : 요세푸스 문제 0 - JAVA(자바)

//<새로 알게된 것>
//StringBuilder 인덱스 값 지우기 : sb.delete(start index , end index)

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        sb.append('<');

        while(!q.isEmpty()){
            for(int i=0; i<K-1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append('>');
        System.out.println(sb);
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("<");
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        Queue<Integer> q = new LinkedList<>();
//        //값 넣어주기.
//        for(int i=1; i<=N; i++){
//            q.offer(i);
//        }
//
//        //Q 알고리즘 : K번 째 단위로 인원이 사라지니, K-1 까지는 poll한 값을 다시 offer해주고
//        //           K번 째 인원은 poll 해서 없애준 후, 값을 출력한다.
//        while(!q.isEmpty()){
//            for(int i=1; i<=K; i++){
//                if(i == K){
//                    sb.append(q.poll()).append(", ");
//                    break;
//                }
//                q.offer(q.poll());
//            }
//        }
//        //현재 출력값 : <3, 6, 2, 7, 5, 1, 4, > 이므로, 끝에 2자리 지워주기.
//        sb.delete(sb.length()-2,sb.length());
//        sb.append(">");
//        System.out.println(sb);
//    }
