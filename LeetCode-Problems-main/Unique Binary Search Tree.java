/*
96. Unique Binary Search Trees
Solved
Medium
Topics
Companies
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
  */

class Solution {
    public int numTrees(int n) {
        int[] uniqTree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uniqTree[i] = 1;
        }

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                total += uniqTree[root - 1] * uniqTree[nodes - root];
            }
            uniqTree[nodes] = total;
        }

        return uniqTree[n];        
    }
}
