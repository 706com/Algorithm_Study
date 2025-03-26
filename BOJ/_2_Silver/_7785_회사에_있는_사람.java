package BOJ._2_Silver;

//[250327] 7분

import java.io.*;
import java.util.*;

public class _7785_회사에_있는_사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if(command.equals("enter")){
                map.put(name,1);
            } else if (command.equals("leave")) {
                map.remove(name);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,Collections.reverseOrder());
        for(String x : list){
            System.out.println(x);
        }
    }
}
