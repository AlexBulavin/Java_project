package Lesson5;

/*
Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false,
если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
буква может не меняться, а остаться такой же. (Например, note - code)

Пример 1:
Input: s = "foo", t = "bar"
Output: false
Пример 2:
Input: s = "paper", t = "title"
Output: true

f -> b
o -> a
o ! r

пример 2
p t
a i
e l
r e

Input: s = "paper", t = "titli"
Output: false


Input: s = "paper", t = "tiple"
Output: false

*/
import java.util.HashMap;
import java.util.Map;


public class lesson2 {

    static boolean izomorf(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Character> db = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (db.containsKey(a.charAt(i))) {
                if (b.charAt(i) != db.get(a.charAt(i))) {
                    return false;
                }
            }
        else{
                db.put(a.charAt(i), b.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "paper";
        String word2 = "title";
System.out.println(izomorf(word1, word2)&&izomorf(word2, word1));

    }
}
