package BOJ._2_Silver;

//소요시간 : 33분


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean zero = false;
        boolean one = false;

        int countOne = 0;
        int countZero = 0;

        // 0 뒤집는 갯수 세기
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                if(!zero) {
                    countZero++;
                }
                zero = true;
            }
            else{
                zero = false;
            }
        }
        if(countZero == 0){
            System.out.println("0");
            return;
        }

        // 1 뒤집는 갯수 세기
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                if(!one) {
                    countOne++;
                }
                one = true;
            }
            else{
                one = false;
            }
        }
        if(countOne == 0){
            System.out.println("0");
            return;
        }

        System.out.println(Math.min(countZero,countOne));
    }
}
