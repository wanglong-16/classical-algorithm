package search.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-03-20 09:01:24
 * @author: wanglong16@meicai.cn
 */
public class Practices {

    /**
     * x 的平方根
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        int left = 1, right = x, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long power = (long) mid * mid;
            if (power == x) {
                return mid;
            } else if (power > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (long) mid * mid <= x ? mid : mid - 1;
    }

    /**
     * 378. 有序矩阵中第 K 小的元素
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     * 示例 1：
     * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * 输出：13
     * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
     * 示例 2：
     *
     * 输入：matrix = [[-5]], k = 1
     * 输出：-5
     *
     * [[1, 5, 9],
     * [10,11,13],
     * [12,13,15]]
     */
    public int kthSmallest(int[][] matrix, int k) {
        int min = 1, max = matrix.length, mid = 0;
        while (min <= max) {
            mid = (max + min) / 2;
            if (mid * mid == k) {
                return matrix[mid][mid];
            } else if (k < mid * mid) {
                //mid 偏大
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        int index = mid - 1;
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i <= index; i++) {
            arr.add(matrix[i][index]);
            arr.add(matrix[index][i]);
        }
        Collections.sort(arr);
        return arr.get(k - (index * index));
    }

}
