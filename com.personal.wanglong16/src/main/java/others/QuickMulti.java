package others;

/**
 * @description: 快速乘
 * 俄罗斯农民乘法
 * 俩数相乘：被乘数每次除2下取整， 乘数每次乘2。当小数 = 0 时，把对应每次乘数为奇数的被乘数累加得到结果
 *
 * 原理： 被乘数每次除2取余，的过程其实是被乘数转换为二进制的过程，乘数每次挑选奇数相加的过程是
 * 被乘数对应二进制位为一时累加的过程
 * @version: 1.0
 * @date: 2021-03-14 18:05:04
 * @author: wanglong16@meicai.cn
 *
 * 6 * 12
 *
 * 3  1  0
 * 24 48 96
 * 72
 */
public class QuickMulti {

    public static void main(String[] args) {
        System.out.println(24 * 566);
        System.out.println("========");
        System.out.println(quickMulti(24, 566));
    }

    private static int quickMulti(int m, int n) {
        int min = Math.min(m, n), max = Math.max(m, n), result = 0;
        while (min > 0) {
            min = min >> 1;
            max = max << 1;
            if ((min & 1) == 1) {
                result += max;
            }
        }
        return result;
    }

}
