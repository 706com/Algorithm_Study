package LeetCode.Easy;

//[241113] 소요시간 : 12분

import java.util.*;

public class _118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        int[][] dp = new int[numRows+1][numRows+1];

        dp[1][1] = 1;
        List<Integer> list = new ArrayList<>();
        list.add(dp[1][1]);
        result.add(list);
        if(numRows>1){
            list = new ArrayList<>();
            dp[2][1] = 1;
            dp[2][2] = 1;
            list.add(dp[2][1]);
            list.add(dp[2][2]);
            result.add(list);

            for(int i=3; i<=numRows; i++){
                list = new ArrayList<>();
                for(int j=1; j<=i; j++){
                    if(j==1){
                        dp[i][j] = 1;
                        list.add(dp[i][j]);
                        continue;
                    }
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    list.add(dp[i][j]);
                }
                result.add(list);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return result;
    }
}
