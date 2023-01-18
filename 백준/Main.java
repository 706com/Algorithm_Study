import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        //입력받은 블록의 최소 높이 ~ 최대 높이까지 각 높이마다 소요되는 시간을 계산하여 최소 소요 시간을 찾는다.
        for (int i = min; i <= max; i++) {
            int blocks = b; //인벤토리에 있는 블록의 개수
            int time = 0; //블록의 높이가 i일 떄 소요되는 시간

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j][k] > i) { //블록 제거 2초
                        time += (board[j][k] - i) * 2;
                        blocks += (board[j][k] - i);
                    } else if (board[j][k] < i){ //블록 쌓기 1초
                        time += (i - board[j][k]);
                        blocks -= (i - board[j][k]);
                    }
                }
            }

            // - 남은 블럭이 0개 이상이고, 지금까지의 최단 시간과 같거나 더 짧으면 시간과 높이를 갱신한다.
            // - 같은 시간일 경우 높이가 더 높은게 선택되기 때문에 같은 경우도 시간과 높이를 갱신한다.
            if (blocks >= 0 && minTime >= time) {
                minTime = time;
                height = i;
            }
        }

        System.out.println(minTime + " " + height);
    }
}