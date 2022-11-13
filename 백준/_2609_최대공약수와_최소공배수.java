package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2609_최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList Aarr = new ArrayList();
        for(int i=1; i<=A; i++){
            if(A % i == 0){
                Aarr.add(i);
            }
        }
        ArrayList Barr = new ArrayList();
        for(int i=1; i<=B; i++){
            if(B % i == 0){
                Barr.add(i);
            }
        }

        int low,mid,high;
        int cnt = 0;
        low = 0;
        mid = 0;
        high = Aarr.size()-1;

        while(low<=high){
            mid = (low+high) / 2;
            // key = Barr.get(cnt);
        }
    }
}
