package cn.chenhuanming.leet.code.medium;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        String res = new 把数组排成最小的数().minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(res);
    }

    public String minNumber(int[] nums) {
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }
        quicksort(list, 0, list.length - 1);
        StringBuilder builder = new StringBuilder();
        for (String str : list) {
            builder.append(str);
        }
        return builder.toString();
    }

    private void quicksort(String[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quicksort(nums, left, mid - 1);
            quicksort(nums, mid + 1, right);
        }
    }

    private int partition(String[] nums, int left, int right) {
        int i = left;
        for (int j = i; j < right; j++) {
            if ((nums[j] + nums[right]).compareTo((nums[right] + nums[j])) < 0) {
                String temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        String temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        return i;
    }
}
