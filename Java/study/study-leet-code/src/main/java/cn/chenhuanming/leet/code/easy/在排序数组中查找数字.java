package cn.chenhuanming.leet.code.easy;

public class 在排序数组中查找数字 {
    public static void main(String[] args) {
        在排序数组中查找数字 instance = new 在排序数组中查找数字();
        int res = instance.search(new int[]{1}, 1);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;

        if (right >= left) {
            return right - left + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
