/**
 * @description: 回溯算法
 * @version: 1.0
 * @date: 2021-07-31 08:06:22
 * @author: wanglong16@meicai.cn
 */
package backtrack;

/**
 * 模版
 *      public void backTracking(参数列表) { // 参数列表，字符串用 StringBuilder, 其他元素用ArrayList 来支持撤销操作
 *         if (递归结束条件) { // 结束条件一般是元素等于某个阈值
 *             res.add(sb.toString()); //摘果
 *             return;
 *         }
 *         List<Character> characterList = phoneDigits.get(digit.charAt(index));
 *         for (Character chr : characterList) {
 *             if (list.size() != 0) {
 *                 //防重复，剪枝 当某个条件下的分支不满足条件时，提前终止，不再回溯
 *                 if (candidate < list.get(list.size() - 1)) {
 *                     continue;
 *                 }
 *             }
 *             sb.append(chr); // 添加某个元素
 *             backTracking(digit, index + 1, sb);  //访问下一层，
 *             sb.deleteCharAt(sb.length() - 1);  // 撤销添加操作【这就是要回溯】，访问本层下一个元素
 *         }
 *     }
 */
