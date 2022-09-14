package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.Utils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/submissions/
 */
public class 最小的k个数 {

    public static void main(String[] args) {
        int[] res = new 最小的k个数().getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10);
        Utils.println(res);
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        int i = quicksort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, i + 1);
    }

    private int quicksort(int[] arr, int left, int right, int k) {
        int mid = partition(arr, left, right);
        if (mid == k - 1) {
            return mid;
        }
        return mid > k - 1 ? quicksort(arr, left, mid - 1, k) : quicksort(arr, mid + 1, right, k);
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[right]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
