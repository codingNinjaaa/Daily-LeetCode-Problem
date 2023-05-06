import java.util.Arrays;

public class May06_2023_Problem_1498 {
    public int numSubseq(int[] nums, int target) {
        /*
        3, 5, 6, 7
        l = 0, r = n-1 = 3
        */
        int n = nums.length, left = 0, right = n-1, answer = 0, mod = 1000000007;

        Arrays.sort(nums);

        int[] powerOf2 = new int[n];
        powerOf2[0] = 1;
        for(int i = 1 ; i<n ;i++){
            powerOf2[i] = (powerOf2[i-1] * 2) % mod;
        }

        while(left <= right){
            if(nums[left] + nums[right] > target){
                right--;
            }else{
                answer += powerOf2[right - left];
                answer %= mod;
                left++;
            }
        }
        return answer;
        /*
            Time complexity: O(n*log(n))
            Space complexity: O(n)
        */
    }
}
