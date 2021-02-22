package core;

import util.BitUtil;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-02-18 10:12:58
 * @author: wanglong16@meicai.cn
 */
public class BitOperation {

    //基本操作

    /**
     * 同为1 结果得 1 其他为0，常用的操作是 通过和 2的n次 - 1做 & 运算，只保留后n位，其他位置0
     */
    public void bitOptAnd() {
        int n = (int) (10000 * Math.random());
        System.out.println("n ====> " + n);
        BitUtil.printIntBits(n);
        // 3 = 111
        n &= 7; //只保留最后的三位
        System.out.println("和7与保留最后三位 ======= ");
        BitUtil.printIntBits(n);

        long l = (long) (10000 * Math.random());
        System.out.println("l ====> " + l);
        BitUtil.printLongBits(l);
        // 3 = 111
        l &= 15L; //只保留最后的4位
        System.out.println("和15与保留最后4位 ======= ");
        BitUtil.printLongBits(l);
    }

    /**
     * 同为0得0，其他情况得1
     */
    public void bitOptOr() {
        int n = (int) (1000000 * Math.random());
        System.out.println("n ====> " + n);
        BitUtil.printIntBits(n);
        n |= ~(1 << 7) + 1;
        System.out.println("保留低7位，其他位都置1");
        BitUtil.printIntBits(n);
    }

    /**
     * 相同为0，不同得1
     */
    public void bitOptXOr() {
        int n = (int) (1000000 * Math.random());
        System.out.println("n ====> " + n);
        BitUtil.printIntBits(n);
        n ^= n;
        System.out.println("自身异或得0"); //相同的值异或得0
        BitUtil.printIntBits(n);
    }

    /**
     * a ^ b = c => a ^ c = b 、 b ^ c = a
     */
    public void bitXOR() {
        int m = 2 ^ 3;
        System.out.println((m ^ 3) == 2);
    }

    public void bitOptNot() {
        int n = (int) (1000000 * Math.random());
        System.out.println("n ====> " + n);
        BitUtil.printIntBits(n);
        n = ~n;
        System.out.println("取反");
        BitUtil.printIntBits(n);
    }

    //位运算技巧总结

    /**
     * 1 << n 是设置第 n 位为 1。
     * ~(1 << n) 是设置第 n 位为 0，且全部低位为 1。相当于取得 （2的n次 -1）
     * num &= ~(1 << n) 是将 num 第 n 位设置为 0。
     */
    public void bitOptMakeLowNToZero(int num, int posN) {
        System.out.println(String.format("将%s的第%s位置为0",num, posN));
        BitUtil.printIntBits(num);
        num &= ~(1 << posN);
        BitUtil.printIntBits(num);
    }

    /**
     * ~(1 << n) + 1 是设置高 n 位为 1，且全部低位为 0
     * num |= ~(1 << n) + 1 是将 num 第 高 位设置为 1。
     * @param num
     * @param posN
     */
    public void bitOptResetHighNToOne(int num, int posN) {
        System.out.println(String.format("将%s的高%s位置为1，保留低%s位",num, posN, posN));
        BitUtil.printIntBits(num);
        num |= ~(1 << posN) + 1;
        BitUtil.printIntBits(num);
    }

    /**
     * 一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的 1。
     * n & n - 1 将n的最后一位1置0
     * @param n
     */
    public void bitOptNAndNMinusOne(int n) {
        System.out.println("n & n - 1 ====== ");
        int count;
        for (count = 0; n != 0; ++count) {
            BitUtil.printIntBits(n);
            n &= n - 1; //zeroing out the least significant nonzero bit
        }
        System.out.println("n bit one total " + count);
    }

    /**
     * 判断某位是否为1
     */
    public boolean checkPosBitIsOne(int num, int pos) {
        return (num & (1 << pos)) == 1 << pos;
    }

    /**
     * 原码、反码、补码
     */
    public void bitCode() {

    }

}
