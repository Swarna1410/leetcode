class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        
        for (int i = 1; i < n; i++) {
            // If two adjacent balloons have the same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Remove the one with smaller removal time
                if (neededTime[i - 1] <= neededTime[i]) {
                    totalTime += neededTime[i - 1];
                } else {
                    totalTime += neededTime[i];
                    // Keep the higher time balloon for future comparison
                    neededTime[i] = neededTime[i - 1];
                }
            }
        }
        return totalTime;
    }
}
