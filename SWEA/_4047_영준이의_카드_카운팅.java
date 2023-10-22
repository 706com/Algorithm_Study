package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _4047_영준이의_카드_카운팅 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        int Scount = 0;
        int Dcount = 0;
        int Hcount = 0;
        int Ccount = 0;

        while(count<=T){
            sb.append('#').append(count);
            String str = br.readLine();
            count++;

            boolean[] S = new boolean[14];
            boolean[] D = new boolean[14];
            boolean[] H = new boolean[14];
            boolean[] C = new boolean[14];
            boolean check = false;

            while(str.length()!=0){
                String TXY = str.substring(0,3);
                str = str.substring(3);

                char shape = TXY.charAt(0);
                String numString = TXY.substring(1);
                int num = Integer.parseInt(numString);

//                System.out.println(shape +" "+num);

                if(shape == 'S'){
                    if(S[num]){
                        sb.append(" ERROR");
                        check = true;
                        break;
                    }
                    S[num] = true;
                }
                else if(shape == 'D'){
                    if(D[num]){
                        sb.append(" ERROR");
                        check = true;
                        break;
                    }
                    D[num] = true;
                }
                else if(shape == 'H'){
                    if(H[num]){
                        sb.append(" ERROR");
                        check = true;
                        break;
                    }
                    H[num] = true;
                }
                else{
                    if(C[num]){
                        sb.append(" ERROR");
                        check = true;
                        break;
                    }
                    C[num] = true;
                }

                Scount = 0;
                Dcount = 0;
                Hcount = 0;
                Ccount = 0;
                for(int i=1; i<=13; i++){
                    if(!S[i]){
                        Scount++;
                    }
                }
                for(int i=1; i<=13; i++){
                    if(!D[i]){
                        Dcount++;
                    }
                }
                for(int i=1; i<=13; i++){
                    if(!H[i]){
                        Hcount++;
                    }
                }
                for(int i=1; i<=13; i++){
                    if(!C[i]){
                        Ccount++;
                    }
                }
            }
            if(!check) {
                sb.append(' ').append(Scount);
                sb.append(' ').append(Dcount);
                sb.append(' ').append(Hcount);
                sb.append(' ').append(Ccount);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
