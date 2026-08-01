class Solution {
    public long findMax(int n, int[] a, int[] b, int[] k) {
        long[] diff = new long[n + 1];

        int m = a.length;

        for (int i = 0; i < m; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }

        long curr = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            max = Math.max(max, curr);
        }

        return max;
    }
}