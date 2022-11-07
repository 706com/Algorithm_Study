package 백준;

//2231 : 분해합
//새로 알게된 것
//각 자리 수의 합 구하기 : while(num !=0) {sum += num%10; num = num/10;}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _2231_분해합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++){
            int num = i;
            int sum=0;

            while(num != 0){
                sum = sum + num%10;
                num = num/10;
            }
            //발견하자마자 break을 통해 반복문을 종료시킨다.
            if(i + sum == N){
                System.out.println(i);
                break;
            }
            //만일 끝까지 돌았는데도 if문을 거치지 못한다면 없는 것 이므로
            else if(i == N){
                System.out.println("0");
            }
        }
    }
}
