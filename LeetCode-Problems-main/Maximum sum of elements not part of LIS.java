class Solution {
     static TreeMap<Integer, int[]> mp = new TreeMap<>();

    // insert a value into the map while 
    // maintaining optimal LIS information
    static void insert(int val) {
        Map.Entry<Integer, int[]> it = mp.ceilingEntry(val);

        int len = 1;
        int sum = val;

        // find the best LIS ending at a value less than current
        Map.Entry<Integer, int[]> prev = mp.lowerEntry(val);
        if (prev != null) {
            len = prev.getValue()[0] + 1;
            sum = prev.getValue()[1] + val;
        }

        // remove all dominated entries (length <= current and key > val)
        List<Integer> toerase = new ArrayList<>();
        while (it != null) {
            if (it.getValue()[0] > len) break;
            toerase.add(it.getKey());
            it = mp.higherEntry(it.getKey());
        }

        for (int key : toerase) {
            mp.remove(key);
        }

        // store current value with LIS length and sum
        mp.put(val, new int[]{len, sum});
    }

    // function to compute maximum sum of elements not in the LIS
    static int nonLisMaxSum(int[] arr) {
        mp.clear();
        for (int val : arr) {
            insert(val);
        }

        int[] last = mp.lastEntry().getValue();
        int totalSum = Arrays.stream(arr).sum();
        int lisSum = last[1];

        return totalSum - lisSum;
    }
}
