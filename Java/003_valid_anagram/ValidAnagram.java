// LeetCode Problem: https://leetcode.com/problems/group-anagrams/

// import java.lang.*;


class Solution {
    public boolean isAnagram(String s, String t) {
        // Check edge case: if the lengths of the strings are different or null, they cannot be anagrams
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
     
        // Create a character array to store the frequency of each character in the string while also including unicode characters
        int[] charCount = new int[256]; // Assuming ASCII characters

        // Iterate through the characters in the first string
        for(int i=0; i < s.length(); i++){
            // Increment the count for the character in the first string
            charCount[s.charAt(i)]++;
            // Decrement the count for the character in the second string
            charCount[t.charAt(i)]--;
        }

        // Iterate through the character count array
        for(int i=0; i < charCount.length; i++){
            // If the count is not 0, then the strings are not anagrams
            if(charCount[i] != 0){
                return false;
            }
        }

        // If the loop completes without returning false, then the strings are anagrams
        return true;   
    }
}


public class ValidAnagram {
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        
        // Check if the two strings are anagrams
        boolean result = solution.isAnagram(s, t);
        
        // Print the result
        System.out.println("Are \"" + s + "\" and \"" + t + "\" anagrams? " + result);


        // Test with different strings
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" anagrams? " + result2); // Output: false
    }
}
