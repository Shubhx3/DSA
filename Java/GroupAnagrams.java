// LeetCode Problem: https://leetcode.com/problems/group-anagrams/
// Problem Statement: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// For example, "anagram" and "nagaram" are anagrams.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation: The order of output does not matter.

// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Explanation: There is one anagram group consisting of the empty string.

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
// Explanation: There is one anagram group consisting of the single character "a".
// Note: The order of the output does not matter, so the groups can be in any order.

// Example 4:
// Input: strs = ["abc","bca","cab","xyz","zyx"]
// Output: [["abc","bca","cab"],["xyz","zyx"]]
// Explanation: The order of output does not matter.
// The groups can be in any order.
// The output is a list of lists, where each inner list contains the anagrams grouped together.


import java.util.*;

// GroupAnagramsblic class GroupAnagrams {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         // Create a HashMap to store the anagrams
//         // The key is the sorted string and the value is a list of anagrams
//         Map<String, List<String>> map = new HashMap<>();

//         // Iterate through the array of strings
//         for (String str : strs) {
//             // Sort the string to get the key for the map
//             char[] chars = str.toCharArray();
//             Arrays.sort(chars);
//             String sortedStr = new String(chars);

//             // Add the original string to the list of anagrams in the map
//             map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
//         }

//         // Return the values of the map as a list of lists
//         return new ArrayList<>(map.values());
//     }
// }   


class Solution {
    public List<List<String>> groupAnagrams(String[] strs){

        // Let's check edge case first
        // If the input array is null or empty, return an empty list
        // This is important to handle cases where the input is not valid
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a HashMap to store the anagrams
        Map<String, List<String>> ansMap = new HashMap<>();

        // Let's use 26 letters of the alphabet as a key
        // Create a integer array to store the frequency of each letter in the string
        // The size of the array is 26 because there are 26 letters in the English alphabet
        // The index of the array corresponds to the letter (0 for 'a', 1 for 'b', ..., 25 for 'z')
        // For example, if the string is "abc", the frequency array will be [1, 1, 1, 0, 0, ..., 0]
        // This allows us to use the frequency array as a key in the map
        // The frequency array is a good choice for a key because it is unique for each anagram group
        // For example, "abc" and "cab" will have the same frequency array [1, 1, 1, 0, 0, ..., 0]
        // This allows us to group the anagrams together in the map
        // The frequency array is a good choice for a key because it is unique for each anagram group

        // For example, "abc" and "cab" will have the same frequency array [1, 1, 1, 0, 0, ..., 0]
        // This allows us to group the anagrams together in the map

        int[] freq = new int[26];

        // Iterate through the array of strings
        for (String str : strs) {
            // Reset the frequency array for each string
            Arrays.fill(freq, 0);

            // Calculate the frequency of each letter in the string
            // For example, if the string is "abc", the frequency array will be [1, 1, 1, 0, 0, ..., 0]
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            // Convert the frequency array to a string to use as a key in the map
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append(count).append("#");  // Use '#' as a separator to avoid confusion between different frequencies
                // For example, if the frequency array is [1, 1, 1, 0, 0, ..., 0], the string will be "1#1#1#0#0#...#0#"
                // This allows us to use the frequency array as a key in the map
                // The '#' separator is important to avoid confusion between different frequencies and also to avoid key collisions
            }

            // Convert the StringBuilder to a string to use as a key in the map
            // The key is the frequency array as a string
            String key = sb.toString();

            // Add the original string to the list of anagrams in the map
            ansMap.computeIfAbsent(key, _ -> new ArrayList<>()).add(str);
        }

        // Return the values of the map as a list of lists
        // The values of the map are the lists of anagrams grouped together
        // The return type is List<List<String>> because we want to return a list of lists
        // The outer list contains the groups of anagrams and the inner lists contain the anagrams in each group
        // The order of the output does not matter, so the groups can be in any order
        return new ArrayList<>(ansMap.values());

    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // Second example usage with different strings
        String[] strs2 = {"abc", "bca", "cab", "xyz", "zyx"};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("Grouped Anagrams: " + result2); // Output: [["abc","bca","cab"],["xyz","zyx"]]

        // Test with empty string
        String[] strs3 = {""};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("Grouped Anagrams: " + result3); // Output: [[""]]

        // Test with single character
        String[] strs4 = {"a"};
        List<List<String>> result4 = solution.groupAnagrams(strs4);
        System.out.println("Grouped Anagrams: " + result4); // Output: [["a"]]

        // Test with duplicate numbers
        String[] strs5 = {"abc", "cba", "bac", "xyz", "zyx"};
        List<List<String>> result5 = solution.groupAnagrams(strs5);
        System.out.println("Grouped Anagrams: " + result5); // Output: [["abc","cba","bac"],["xyz","zyx"]] 
    }
}