package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        st.push(1);
        while(!st.isEmpty()){
            int num = Integer.parseInt(br.readLine());
            if(st.peek() < num && !st.isEmpty()){
                for(int i=st.peek()+1; i<=num; i++){
                    st.push(i);
                }
            }

            else if(st.peek() > num){

            }
            int before = num;
        }

    }
}