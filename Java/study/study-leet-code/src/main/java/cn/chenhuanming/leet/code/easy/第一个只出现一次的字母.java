package cn.chenhuanming.leet.code.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class 第一个只出现一次的字母 {
    public static void main(String[] args) {

    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, i);
            } else if (map.get(c) == -1) {
            } else {
                map.put(c, -1);
            }
        }

        int small = Integer.MAX_VALUE;
        char res = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < small) {
                small = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
