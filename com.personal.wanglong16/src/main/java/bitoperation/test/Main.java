package bitoperation.test;

import bitoperation.core.BitOperation;
import bitoperation.util.BitUtil;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-02-18 10:30:34
 * @author: wanglong16@meicai.cn
 */
public class Main {

    public static void main(String[] args) {
        BitOperation operation = new BitOperation();
        //operation.bitOptResetHighNToOne(12351, 15);
       // operation.bitOptNAndNMinusOne(12351);

        BitUtil.printIntBits(-1);
    }
}
