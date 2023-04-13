import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class src {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            arr[i][0] = M;
            arr[i][1] = D;

        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        for(int i=0; i<N; i++){
            System.out.println(arr[i][0]+" " +  arr[i][1]);
        }

        int maxDay = arr[0][1]; //최대데이
        int result = 0;

        for(int i=0; i<N; i++){
            if(maxDay == arr[i][1]){
                pq.offer(arr[i][0]);
            }
            else{
                if(!pq.isEmpty()) {
                    result += pq.poll();
                    maxDay--;
                    continue;
                }

                if(maxDay == arr[i][1]){
                    pq.offer(arr[i][0]);
                }
                else if(maxDay != arr[i][1]){
                    continue;
                }
            }
        }

        if(!pq.isEmpty())
            result += pq.poll();

        System.out.println(result);

    }

}