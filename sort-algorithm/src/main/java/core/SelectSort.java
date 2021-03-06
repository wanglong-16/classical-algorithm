package core;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-03-05 16:11:21
 * @author: wanglong16@meicai.cn
 */
public class SelectSort implements SortInf{

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i], minIndex = i;
            //find min value
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                //swap minIndex and i
                arr[minIndex] = arr[minIndex] + arr[i];
                arr[i] = arr[minIndex] - arr[i];
                arr[minIndex] = arr[minIndex] - arr[i];
            }
        }

        for (Integer in : arr) {
            System.out.println(in);
        }
    }
}
