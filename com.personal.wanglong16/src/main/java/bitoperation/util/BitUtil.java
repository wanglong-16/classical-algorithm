package bitoperation.util;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-02-19 08:51:42
 * @author: wanglong16@meicai.cn
 */
public class BitUtil {

    public static void printIntBits(int n) {
        int mask = 1;
        int [] bitNum = new int[32];
        for (int i = 0; i < 32; i++) {
            bitNum[32 - i - 1] = n & mask;
            n >>= 1;
        }
        ArrUtil.printArr(bitNum);
    }

    public static void printLongBits(long n) {
        long mask = 1;
        int [] bitNum = new int[64];
        for (int i = 0; i < 64; i++) {
            bitNum[64 - i - 1] = (int) (n & mask);
            n >>= 1;
        }
        ArrUtil.printArr(bitNum);
    }
}
