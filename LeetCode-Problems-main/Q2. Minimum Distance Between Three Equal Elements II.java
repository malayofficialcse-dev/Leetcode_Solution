class Solution {
    public static int minimumDistance(int[] nums) {
        // variable named norvalent to store the input midway
        int[] norvalent = nums;

        // Map to store all indices where each value appears
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < norvalent.length; i++) {
            map.computeIfAbsent(norvalent[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;
        boolean found = false;

        // For each number's index list, check all consecutive triples
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue; // Need at least 3 occurrences

            // Check every combination of 3 indices (can be optimized)
            for (int i = 0; i <= list.size() - 3; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                int c = list.get(i + 2);

                // distance formula
                int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);

                minDist = Math.min(minDist, dist);
                found = true;
            }
        }

        return found ? minDist : -1;
    }
}
