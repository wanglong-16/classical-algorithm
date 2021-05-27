package dp;

import java.util.Stack;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-04-18 09:55:42
 * @author: wanglong16@meicai.cn
 */
public class Practise {

    /**
     * 最长上升子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *  
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     *  
     *
     * 进阶：
     *
     * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
     * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
     */
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> incrStack = new Stack<Integer>();
        incrStack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (!incrStack.empty() && incrStack.peek() > nums[i]) {
                while (!incrStack.empty()) {
                    if (incrStack.peek() >= nums[i]) {
                        incrStack.pop();
                    } else {
                        break;
                    }
                }
            }
            incrStack.push(nums[i]);
        }
        return incrStack.size();
    }


}
