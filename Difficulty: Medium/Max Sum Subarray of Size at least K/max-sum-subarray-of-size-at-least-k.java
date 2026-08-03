class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        // maxSumEndingHere[i] = Maximum subarray sum ending at index i
        int[] maxSumEndingHere = new int[n];
        maxSumEndingHere[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxSumEndingHere[i] = Math.max(arr[i], maxSumEndingHere[i - 1] + arr[i]);
        }

        // Sum of first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];

            // Window of exactly size k
            ans = Math.max(ans, windowSum);

            // Window extended with best subarray ending before it
            ans = Math.max(ans, windowSum + maxSumEndingHere[i - k]);
        }

        return ans;
    }
}