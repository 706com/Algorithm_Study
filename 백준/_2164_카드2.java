package 백준;

//2164 : 카드2
//새로 알게된 것
//Queue 라이브러리 함수 (offer(), poll(), peek())
//Queue 선언 방법 Queue<Integer> q = new LinkedList<>();
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class _2164_카드2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        //가지고 있는 카드 수 q에 순서대로 넣기
        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        //q에 남아있는 카드가 한 장이 남을 때 까지 반복 (한장 버리고, 한장은 맨 뒤에 넣는 과정 반복)
        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.peek());
    }
}
