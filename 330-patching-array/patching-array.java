class Solution {
    public int minPatches(int[] nums, int n) {
        long coverage = 1; // This will keep track of the largest number that can be formed by the sum of subsets of sorted nums
        int patches = 0; // This will count the number of patches (numbers) we need to add
        int index = 0; // Index to iterate through the nums array

        // Loop until the coverage is less than or equal to n
        while (coverage <= n) {
            // If the current index is within the bounds of the nums array
            // and the current number at nums[index] can be used to extend coverage
            if (index < nums.length && nums[index] <= coverage) {
                // Increment coverage by nums[index] and move to the next number in nums
                coverage += nums[index++];
            } else {
                // Increment patches since we need to add a new number to extend coverage
                patches++;
                // Double the coverage, simulating the addition of the number equal to the current coverage
                coverage <<= 1;
            }
        }

        // Return the number of patches needed to ensure a complete range from 1 to n
        return patches;
    }
}