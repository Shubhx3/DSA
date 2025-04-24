// LeetCode Problem: https://leetcode.com/problems/valid-sudoku/description/

import java.util.HashSet;
import java.util.Set;

class Solution{
    public boolean isValidSudoku(char[][] board){
        // We will use a HashSet to keep track of rows, columns, and boxes

        // Let's start with the constants for the size of the board
        int N = 9;

        // Create a HashSet to keep track of the numbers in the rows, columns, and boxes
        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[] boxes = new HashSet[N];

        // Initialize the HashSets for rows, columns, and boxes to accept characters
        for(int r = 0; r < N; r++){
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        // Iterate through the board
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                // Get the current character value from the board
                char val = board[r][c];

                // If the value is not empty ('.'), we need to check for duplicates: Edge case
                if(val == '.'){
                    continue; // Skip empty cells
                }

                // Calculate the rows hashset for duplicates
                if(rows[r].contains(val)){
                    return false; // Duplicate found in the row
                }
                // Else we add the value to the row's hashset
                rows[r].add(val);

                // Calculate the columns hashset for duplicates
                if(cols[c].contains(val)){
                    return false; // Duplicate found in the column
                }
                // Else we add the value to the column's hashset
                cols[c].add(val);

                // Calculate the boxes hashset for duplicates
                int idx = (r/3) * 3 + (c/3); // Calculate the box index
                if(boxes[idx].contains(val)){
                    return false; // Duplicate found in the box
                }
                // Else we add the value to the box's hashset
                boxes[idx].add(val);
            }
        }
        // If we reach here, it means there are no duplicates in any row, column, or box
        return true; // The board is valid
    }
}

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example Sudoku board (valid)
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '2', '1', '9', '.', '.', '.'},
            {'.', '6', '.', '.', '.', '5', '9', '8', '.'},
            {'.', '.', '.', '4', '2', '1', '7', '3', '.'},
            {'.', '8', '7', '9', '3', '.', '.', '2', '.'}
        };
        // Example Sudoku board (invalid)
        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '2', '1', '9', '.', '.', '.'},
            {'.', '6', '.', '.', '.', '5', '9', '8', '.'},
            {'.', '.', '.', '4', '2', '1', '7', '3', '.'},
            {'.', '8', '7', '9', '3', '.', '.', '2', '.'}
        };
        // Check if the first board is valid
        boolean isValid = solution.isValidSudoku(board);
        System.out.println("Is the first board valid? " + isValid); // Output: true
        // Check if the second board is valid
        boolean isValid2 = solution.isValidSudoku(board2);
        System.out.println("Is the second board valid? " + isValid2); // Output: false
        // Test with an empty board (valid)
        char[][] emptyBoard = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean isEmptyBoardValid = solution.isValidSudoku(emptyBoard);
        System.out.println("Is the empty board valid? " + isEmptyBoardValid); // Output: true
    }
    
}
