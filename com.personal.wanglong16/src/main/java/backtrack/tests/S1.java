package backtrack.tests;

import java.util.*;

/**
 * @description:
 * @version: 1.0
 * @date: 2021-07-31 08:05:38
 * @author: wanglong16@meicai.cn
 */
public class S1 {

    Map<Character, List<Character>> phoneDigits = new HashMap<Character, List<Character>>() {
        {
            put('2', Arrays.asList('a','b','c'));
            put('3', Arrays.asList('d','e','f'));
            put('4', Arrays.asList('g','h','i'));
            put('5', Arrays.asList('j','k','l'));
            put('6', Arrays.asList('m','n','o'));
            put('7', Arrays.asList('p','q','r','s'));
            put('8', Arrays.asList('t','u','v'));
            put('9', Arrays.asList('w','x','y','z'));
        }
    };

    List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTracking(digits, 0, new StringBuilder());
        return res;
    }

    public void backTracking(String digit, int index, StringBuilder sb) {
        if (index == digit.length()) {
            res.add(sb.toString());
            return;
        }
        List<Character> characterList = phoneDigits.get(digit.charAt(index));
        for (Character chr : characterList) {
            sb.append(chr);
            backTracking(digit, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        S1 s1 = new S1();
        System.out.println(s1.letterCombinations("23"));
    }
}
