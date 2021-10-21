package backtrack.tests;

import java.util.*;

/**
 * @description:
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 *
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 *
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @version: 1.0
 * @date: 2021-07-31 08:53:13
 * @author: wanglong16@meicai.cn
 */
public class S2 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int[] candidates;

    public List<List<Integer>> combinationSumV1(int[] candidates, int target) {
         this.candidates = candidates;
         Arrays.sort(this.candidates);
         backTracking(target, new ArrayList<>());
         return ans;
    }

    public void backTracking(int target, List<Integer> list) {
        int sum = list.stream().reduce(0, Integer::sum);
        if (sum >= target) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (Integer candidate : candidates) {
            if (list.size() != 0) {
                //防重复，剪枝
                if (candidate < list.get(list.size() - 1)) {
                    continue;
                }
            }
            list.add(candidate);
            backTracking(target, list);
            list.remove(list.size() - 1);
        }
    }


    //官解

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

//    List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], combination, ans);
            combination.remove(combination.size() - 1);
        }
    }


    public static void main(String[] args) {
        S2 s2 = new S2();
        System.out.println(s2.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        //1 1 2 5 6 7 10
        // 1 1 6
        //1 2 5
    }

}
