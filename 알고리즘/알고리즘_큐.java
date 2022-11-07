package 알고리즘;
//순서가 있는 데이터들이 있을 때 삽입(insert/add), 삭제(remove/delete)가
//빈번하게 발생한다면 LinkedList를,아닐경우에는 ArrayList

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//enqueue(push) : 큐의 가장 마지막에 데이터를 삽입합니다.
//dequeue(pop) : 큐의 첫 번째 위치에 있는 데이터를 반환하고 큐에서 삭제합니다.
//isEmpty(empty) : 큐가 empty 상태인지 확인합니다.
//clear   : 큐에 저장된 모든 데이터를 삭제하고 큐를 초기화합니다.
//peek(front)    : 큐의 첫 번째 위치에 있는 데이터를 추출합니다. dequeue 메서드와는 달리 큐에서 데이터를 삭제하지 않습니다.
public class 알고리즘_큐 {
    static int[] q = new int[10001];
    static int first = 0;
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch (S) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    if (empty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
            }
        }
    }

    public static void push(int n){
        q[last] = n;
        last++;
    }
    public static int pop(){
        if(last-first == 0)
            return -1;
        else{
            int p = q[first];
            first++;
            return p;
        }
    }

    public static int size(){
        return last-first;
    }
    public static boolean empty(){
        if(last - first == 0){
            return true;
        }
        else
            return false;
    }
    public static int front(){
        if(last - first == 0){
            return -1;
        }
        else
            return q[first];
    }

    public static int back(){
        if(last- first == 0){
            return -1;
        }
        else
            return q[last-1];
    }


}
