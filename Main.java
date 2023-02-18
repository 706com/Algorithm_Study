import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class src {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /**
         * 0~4 :0
         * 5~9 : 1
         * 10~14 :2
         */
        int result = 0;
        while(N>=5){
            result += N/5;
            N /= 5;
        }
        System.out.println(result);
    }
}