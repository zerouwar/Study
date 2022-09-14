package cn.chenhuanming.leet.code.hard;

public class 接雨水 {
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1, right = i + 1;
            int h = height[i];
            while (left >= 0 && right < height.length && height[left] >= h && height[right] >= h) {
                int min = Math.min(height[left], height[right]);
                if (min > h) {
                    ans += (min - h) * (right - left - 1);
                    h = min;
                    for (int j = left; j <= right; j++) {
                        if (height[j] < h) {
                            height[j] = h;
                        }
                    }
                }
                if (height[left] < height[right]) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        接雨水 instance = new 接雨水();
        int trap = instance.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap);
    }

}
