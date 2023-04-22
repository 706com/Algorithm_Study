package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        HashMap<Integer,String> keyNum = new HashMap<>();
        HashMap<String,Integer> keyName = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            String name = br.readLine();
            keyNum.put(i,name);
            keyName.put(name,i);
        }
        for(int i=0; i<M; i++){
            String answer = br.readLine();
            try {
                int num = Integer.parseInt(answer);
                System.out.println(keyNum.get(num));
            } catch(NumberFormatException num) {
                System.out.println(keyName.get(answer));
            }
        }
    }
}