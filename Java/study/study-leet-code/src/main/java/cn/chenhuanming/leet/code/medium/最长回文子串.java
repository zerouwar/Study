package cn.chenhuanming.leet.code.medium;

import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int size = s.length();
        boolean[][] f = new boolean[size][size];
        for (boolean[] f1 : f) {
            Arrays.fill(f1, true);
        }
        int l = 0, r = 0;

        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    f[i][j] = true;
                } else if (j - i == 1) {
                    f[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
                }

                if (f[i][j] && j - i > r - l) {
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
