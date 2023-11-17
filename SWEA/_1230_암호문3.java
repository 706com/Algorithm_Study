package SWEA;

//16분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1230_암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while(count<=10){
            int N = Integer.parseInt(br.readLine());
            List<String> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                String command = st.nextToken();
                int x;
                int y;
                String s;
                switch (command){
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j=0; j<y; j++){
                            s= st.nextToken();
                            arr.add(x+j,s);
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j=0; j<y; j++){
                            arr.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int j=0; j<y; j++) {
                            s = st.nextToken();
                            arr.add(arr.size()-1,s);
                        }
                        break;
                }
            }
            System.out.printf("#%d ",count);
            for(int i=0; i<10; i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
            count++;
        }
    }
}
