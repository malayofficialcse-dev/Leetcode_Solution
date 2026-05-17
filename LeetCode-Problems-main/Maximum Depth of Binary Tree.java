class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubHeight = maxDepth(root.left);
        int rightSubHeight = maxDepth(root.right);

        return Math.max(leftSubHeight, rightSubHeight) + 1;
    }
}
