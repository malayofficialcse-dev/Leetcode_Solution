class Solution {
public:
    int dp[21][3002]; // dp array with offset for -1000 to +1000 range
    const int OFFSET = 1000; // Offset to handle negative target values

    // Recursive function to solve the problem
    int solve(int ind, vector<int>& nums, int target) {
        // Base cases
        if (ind >= nums.size()) {
            return target == 0 ? 1 : 0;
        }

        // Check if already computed
        if (dp[ind][target + OFFSET] != -1) {
            return dp[ind][target + OFFSET];
        }

        // Recursively calculate the number of ways
        int ans = 0;
        ans += solve(ind + 1, nums, target - nums[ind]); // Subtract current number
        ans += solve(ind + 1, nums, target + nums[ind]); // Add current number

        return dp[ind][target + OFFSET] = ans; // Store result in dp array
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        memset(dp, -1, sizeof(dp)); // Initialize dp array with -1
        return solve(0, nums, target); // Start recursion from index 0
    }
};
