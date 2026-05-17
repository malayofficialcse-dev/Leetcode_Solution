class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int memo[][]=new int [n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    memo[i][j]=Character.getNumericValue(matrix[i][j]);
                }
                else if(matrix[i][j]=='1'){
                    memo[i][j]=Math.min(Math.min(memo[i-1][j], memo[i][j-1]), memo[i-1][j-1]) + 1;
                }
                max=Math.max(max,memo[i][j]);
            }
        }
        return max*max;
    }
}
