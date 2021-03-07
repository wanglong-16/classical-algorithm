import bitoperation.core.BubbleSort;
import bitoperation.core.SelectSort;
import bitoperation.core.SortInf;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-03-05 15:56:59
 * @author: wanglong16@meicai.cn
 */
public class Main {

    public static void main(String[] args) {
        SortInf bubbleSort = new BubbleSort();
        SortInf selectSort = new SelectSort();
        selectSort.sort(new int[] {1, 4, 8, 2, 3, 1});
    }
}
