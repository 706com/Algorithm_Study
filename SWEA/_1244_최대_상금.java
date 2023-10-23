package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _1244_최대_상금 {

    static char[] arr;

    static int chance;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();

            chance = Integer.parseInt(st.nextToken());
            arr = new char[num.length()];

            for(int i=0; i<num.length(); i++){
                arr[i] = num.charAt(i);
            }

            max = 0;

            dfs(0,0);

            System.out.printf("#%d %d\n",count,max);
            count++;
        }
    }
    static void dfs(int start,int depth) {
        if(depth == chance){
            int num = Integer.parseInt(String.valueOf(arr));

            max = Math.max(max,num);
            return;
        }

        for(int i=start; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i,depth+1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
    }
}
