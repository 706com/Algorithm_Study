package LeetCode;

class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] answer = new int[2];

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(nums[i] + nums[j] == target){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}