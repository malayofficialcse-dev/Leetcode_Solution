class Solution {
    public int nthUglyNumber(int n) {
        int primes[]={2,3,5};
        PriorityQueue<Long>uglyHeap=new PriorityQueue<>();
        HashSet<Long>visited=new HashSet<>();

        uglyHeap.add(1L);
        visited.add(1l);

        long curr=1l;

        for(int i=0;i<n;i++){
            curr=uglyHeap.poll();
            for(int prime : primes){
                long newugly=curr * prime;
                if(!visited.contains(newugly)){
                    uglyHeap.add(newugly);
                    visited.add(newugly);
                }
            }
        }
        return (int )curr;
    }
}
