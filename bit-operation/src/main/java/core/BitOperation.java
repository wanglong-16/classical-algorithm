package core;

import util.ArrUtil;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-02-18 10:12:58
 * @author: wanglong16@meicai.cn
 */
public class BitOperation {

    /**
     * 求整数的二进制数
     */
    public void bitOptAnd() {
        int n = (int) (10000 * Math.random());
        System.out.println("n ====> " + n);
        int mask = 1;
        int [] bitNum = new int[32];
        for (int i = 0; i < 32; i++) {
            bitNum[32 - i - 1] = n & mask;
            n >>= 1;
        }
        ArrUtil.printArr(bitNum);
    }

    public void bitOptOr() {

    }

}
