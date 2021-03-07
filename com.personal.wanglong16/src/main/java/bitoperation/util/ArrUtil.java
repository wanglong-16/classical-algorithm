package bitoperation.util;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-02-18 10:19:00
 * @author: wanglong16@meicai.cn
 */
public class ArrUtil {

    public static void printArr(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(String.format("[%s, ", arr[0]));
            } else if (i == arr.length - 1) {
                System.out.println(String.format("%s] ", arr[arr.length - 1]));
            } else {
                System.out.print(String.format("%s, ", arr[i]));
            }
        }
    }

}
