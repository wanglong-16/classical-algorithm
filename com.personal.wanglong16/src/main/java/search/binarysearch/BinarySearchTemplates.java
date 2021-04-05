package search.binarysearch;


/**
 * @description: 二分查找模版
 * @version: 1.0
 * @date: 2021-03-14 21:53:19
 * @author: wanglong16@meicai.cn
 */
public class BinarySearchTemplates {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 10};
        System.out.println(binarySearch(arr, 8));
    }

    /**
     * 二分查找写法
     */
    private static int binarySearch(int[] source, int target) {
        int left = 0, right = source.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (source[mid] == target) {
                return mid;
            } else {
                // 把中间位置的数排除掉
                if (source[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 模版1
     */

    // jdk 搜索写法
    private static int binarySearch0(byte[] a, int fromIndex, int toIndex, byte key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }

    /**
     *
     时间和空间复杂度：
     时间：O(log n) —— 算法时间
     因为二分查找是通过对查找空间中间的值应用一个条件来操作的，并因此将查找空间折半，
     在更糟糕的情况下，我们将不得不进行 O(log n) 次比较，其中 n 是集合中元素的数目。

     为什么是 log n？
     二分查找是通过将现有数组一分为二来执行的。
     因此，每次调用子例程(或完成一次迭代)时，其大小都会减少到现有部分的一半。
     首先 N 变成 N/2，然后又变成 N/4，然后继续下去，直到找到元素或尺寸变为 1。
     迭代的最大次数是 log N (base 2) 。
      
     空间：O(1) —— 常量空间
     虽然二分查找确实需要跟踪 3 个指标，但迭代解决方案通常不需要任何其他额外空间，
     并且可以直接应用于集合本身，因此需要 O(1) 或常量空间。
     */

}
