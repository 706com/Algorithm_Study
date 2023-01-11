package 백준;
//[백준]10828 : 스택 - JAVA(자바)

//<새로 알게된 것>
//스택 구현하기.
//출력이 많을 때에는 println 대신에 StringBuilder 쓰기.

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _10828_스택 {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void push(int num){
        arr.add(num);
    }
    public static int pop(){
        if(arr.isEmpty()){
            return -1;
        }
        else {
            int result = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            return result;
        }
    }

    public static int size(){
        return arr.size();
    }

    public static int empty(){
        if(arr.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int top(){
        if(arr.isEmpty()){
            return -1;
        }
        else{
            return arr.get(arr.size()-1);
        }
    }
}
