package BOJ._1_Bronze;

//소요 시간 : 14분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11328_Strfry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            int[] arr = new int[26];
            boolean check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String result = st.nextToken();
            
            for(int i=0; i<str.length(); i++){
                // a == 0번지 , b == 1번지 ~~
                int alpha = (str.charAt(i)-'0') - 49;
                arr[alpha]++;
            }

            for(int i=0; i<result.length(); i++){
                int alphabet = (result.charAt(i)-'0') - 49;
                arr[alphabet]--;
            }

            //탐색중 하나라도 0이 아닌게 있다면 불가능 (주어진 알파벳을 이용하여 조합해야 하므로)
            for(int i=0; i<26; i++){
                if(arr[i]!=0){
                    System.out.println("Impossible");
                    check = true;
                    break;
                }
            }
            // 위의 for문을 통과했다면 가능
            if(!check) {
                System.out.println("Possible");
            }
        }
    }
}
