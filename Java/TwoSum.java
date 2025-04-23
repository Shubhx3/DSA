// LeetCode Problem: https://leetcode.com/problems/two-sum/

// Problem Statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
// You must write an algorithm that runs in O(n) time complexity.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 6, we return [0, 1].

// This is a simple problem that can be solved using a HashMap to store the numbers and their indices.
// The idea is to iterate through the array and for each number, check if its complement (target - current number) exists in the map.
// If it does, return the indices of the current number and its complement.
// If it doesn't, add the current number and its index to the map for future reference.
// This approach has a time complexity of O(n) because we only iterate through the array once and look up values in the map in O(1) time.
// The space complexity is also O(n) because we store the numbers and their indices in the map.
// The solution is efficient and works well for large inputs.

// The code is written in Java and uses a HashMap to store the numbers and their indices.
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store the numbers and their indices
        // The key is the number and the value is its index
        // This allows us to check if the complement (target - current number) exists in O(1) time
        Map<Integer, Integer> map = new HashMap<>();


        // Iterate through the array of numbers
        // For each number, calculate its complement (target - current number)
        // Check if the complement exists in the map
        // If it exists, return the indices of the current number and its complement

        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            // The complement is the number we need to find in the map to form the target sum
            // For example, if the current number is 2 and the target is 9, the complement is 7
            int complement = target - nums[i];

            // Check if the complement exists in the map
            // If it exists, return the indices of the current number and its complement
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // If the complement does not exist, add the current number and its index to the map
            // This allows us to check for the complement in future iterations
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class TwoSum {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Output: [0, 1]

        // You can test with other inputs as well
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Indices: " + Arrays.toString(result2)); // Output: [1, 2]


        // Test with duplicate numbers
        // This case is interesting because the same number can be used twice to form the target sum
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Indices: " + Arrays.toString(result3)); // Output: [0, 1]
    }
}