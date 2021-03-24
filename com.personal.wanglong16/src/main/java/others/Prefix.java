package others;

import java.util.Arrays;

/**
 * @description: 前缀算法
 * @version: 1.0
 * @date: 2021-03-24 22:46:49
 * @author: wanglong16@meicai.cn
 */
public class Prefix {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
       // System.out.println(Arrays.toString(calculatePrefixDim1ArrayV1(arr)));

        int[][] arr2 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int[] ar : calculatePrefixDim2Array(arr2)) {
            System.out.println(Arrays.toString(ar));
        }
    }

    /**
     * 一维数组前缀和
     */
    @Deprecated
    public static int[] calculatePrefixDim1Array(int[] arr) {
        int[] ans = new int[arr.length + 1];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            ans[i + 1] = temp;
        }
        return ans;
    }


    public static int[] calculatePrefixDim1ArrayV1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        return arr;
    }

    /**
     * 二维数组前缀和
     */
    public static int[][] calculatePrefixDim2Array(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = arr[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }
        return arr;
    }
}
