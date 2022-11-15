package 백준;

//[백준]2775 : 부녀회장이 될테야 - JAVA(자바)

//<새로 알게된 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2775_부녀회장이_될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T != 0) {
            T--;
            int[] people = new int[15];
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<=14; i++){
                people[i] = i;
            }

            for(int i=0; i<k; i++) {
                for (int j = 2; j <= 14; j++) {
                    people[j] = people[j-1] + people[j];
                }
            }

            System.out.println(people[n]);

        }
    }
}
