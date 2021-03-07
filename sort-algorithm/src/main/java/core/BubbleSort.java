package bitoperation.core;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-03-05 15:54:35
 * @author: wanglong16@meicai.cn
 */
public class BubbleSort implements SortInf{

    public void sort(int[] arr) {
        if (arr.length >= 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] < arr[j - 1]) {
                        //swap j j-1
                        arr[j] = arr[j - 1] + arr[j];
                        arr[j - 1] = arr[j] - arr[j - 1];
                        arr[j] = arr[j] - arr[j - 1];
                    }
                }
            }
        }
        for (Integer in : arr) {
            System.out.println(in);
        }
    }
}
