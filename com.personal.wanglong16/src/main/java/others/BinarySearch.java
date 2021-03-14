package others;

/**
 * @description: 二分查找
 * @version: 1.0
 * @date: 2021-03-14 21:53:19
 * @author: wanglong16@meicai.cn
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 10};
        System.out.println(binarySearch(arr, 8));
    }

    private static int binarySearch(int [] source, int target) {
        int left = 0, right = source.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (source[mid] == target) {
                return mid;
            } else {
                if (source[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
