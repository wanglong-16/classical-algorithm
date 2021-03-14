package others;

/**
 * @description: 快速乘
 * 俄罗斯农民乘法
 * 俩数相乘：小数每次除2下取整， 大数每次乘2。当小数 = 0 时，把对应每次小数为奇数的大数累加得到结果
 *
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
