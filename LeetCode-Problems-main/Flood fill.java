
class Solution {
    public static void helpher(int [][]image,int i,int j,int original,int color){
if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=original|| image[i][j]==color)return;

        image[i][j]=color;
        helpher(image,i-1,j,original,color);
        helpher(image,i+1,j,original,color);
        helpher(image,i,j-1,original,color);
        helpher(image,i,j+1,original,color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original!=color) helpher(image,sr,sc,original,color);
        return image;
    }
}
