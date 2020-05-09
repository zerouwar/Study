package cn.chenhuanming.leet.code.easy;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class X的平方根 {

    public static void main(String[] args) {
        X的平方根 instance = new X的平方根();
        System.out.println(instance.mySqrt(8));
    }

    public int mySqrt(int x) {
        int l = 0 , r = x , res = -1;

        while (l <= r){
            int mid = (r - l) / 2 + l;
            if((long)mid * mid <= x){
                res = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }
}
