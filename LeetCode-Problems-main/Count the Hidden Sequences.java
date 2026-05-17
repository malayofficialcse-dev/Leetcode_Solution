class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum=0;
        long maxi=0;
        long mini=0;
        for(int X :differences){
            sum+=X;
            maxi=Math.max(maxi,sum);
            mini=Math.min(mini,sum);
        }
        return (int )Math.max(0,upper-lower-maxi+mini+1);
    }
}
