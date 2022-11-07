package 백준;

// 10845 : 큐 (선형배열로 풀기)
//새로 알게된 것
//push , pop 할 때의 front, rear 의 이동법

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _10845_큐_선형배열 {
    //주어진 명령의 수 1~10000 최대push = 10000개 -> last : 10001 까지 가야함
    static int[] q = new int[10001];
    static int front;
    static int rear;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            //한 줄씩 읽는 StringTokenizer 로 push 1 같은 문자열 처리 가능
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch(S){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    //이런식으로 함수 밖에서 출력하는 방법이 있고
                    System.out.println(pop());
                    break;
                case "size":
                    //이렇게 함수 안에서 모든 것을 끝낼 수도 있다. 가독성은 함수 안에서 끝내는 것이 좋아보인다.
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
    }
    public static void push(int n){
        q[rear] = n;
        rear++;
    }
    public static int pop(){
        if(rear - front == 0){
            return -1;
        }
        else {
            int p = q[front];
            front++;
            return p;
        }
    }
    public static void size(){
        System.out.println(rear-front);
    }
    public static void empty(){
        if(rear - front == 0){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
    public static void front(){
        if(rear-front == 0){
            System.out.println("-1");
        }
        else {
            System.out.println(q[front]);
        }
    }
    public static void back(){
        if(rear - front == 0){
            System.out.println("-1");
        }
        else {
            System.out.println(q[rear-1]);
        }
    }
}
