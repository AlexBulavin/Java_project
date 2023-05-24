package Lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lesson3 {
    static boolean izomorf2(String a) {
        Map<Character, Character> db = new HashMap<>();
        db.put(')', '(');
        db.put('}', '{');
        db.put('>', '<');
        db.put(']', '[');
        Stack<Character> MyStack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (db.containsValue(a.charAt(i))) {
                MyStack.push(a.charAt(i));
            }
            if (db.containsKey(a.charAt(i))) {
                if ((MyStack.empty())|| MyStack.pop() != db.get(a.charAt(i))) {
                    return false;
                }
            }
        }
        return MyStack.empty();
    }

    public static void main(String[] args) {
        String word1 = "([4+8])";
        System.out.println(izomorf2(word1));
        System.out.println(izomorf2("a+(d*3))"));
        System.out.println(izomorf2("[a+(1*3)"));
        System.out.println(izomorf2("[6+(3*3)]"));
        System.out.println(izomorf2("{a}[+]{(d*3)}"));
        System.out.println(izomorf2("<{a}+{(d*3)}>"));
        System.out.println(izomorf2("{a+]}{(d*3)}"));
    }
}
