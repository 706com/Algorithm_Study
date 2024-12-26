package BOJ._2_Silver;

//[241226] 50분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer time;
        Map<String,Integer> map = new HashMap<>();
        int result = 0;

        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            time = new StringTokenizer(st.nextToken(),":");
            arr[i] += Integer.parseInt(time.nextToken())*60;
            arr[i] += Integer.parseInt(time.nextToken());
        }
//        System.out.println(Arrays.toString(arr));

        String input;
        while((input = br.readLine()) != null){

            if(input.equals("")){
                break;
            }
            st = new StringTokenizer(input);
            time = new StringTokenizer(st.nextToken(),":");

            int timeInt =0;
            timeInt += Integer.parseInt(time.nextToken())*60;
            timeInt += Integer.parseInt(time.nextToken());

            String name = st.nextToken();

            //시작 전까지 출석 한 사람
            if(timeInt<=arr[0]){
                map.put(name,1);
            }

            //총회 종료 ~ 스트리밍 종료
            if(arr[1]<=timeInt && timeInt<=arr[2]){
                if(map.containsKey(name) && map.get(name) == 1){
                    result++;
                    map.put(name,2);
//                    System.out.println(name);
//                    System.out.println(result);
                }
            }
        }
        System.out.println(result);
    }
}
