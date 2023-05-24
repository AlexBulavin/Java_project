package Lesson5;

import java.io.Serial;
import java.util.HashMap;

public class lesson {
/*Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
Вывести данные по сотрудникам с фамилией Иванов.*/

public static void main(String[] args){
    HashMap <Integer, String> Workers = new HashMap<>();
    Workers.put(123456, "Иванов");
    Workers.put(321456, "Васильев");
    Workers.put(234561, "Петрова");
    Workers.put(23432, "Иванов");
    Workers.put(345678, "Иванов");

    for(var currWorker: Workers.entrySet()){//Можно также идти только по ключам или по значениям
    //for(int currWorker: Workers.keySet()){ //по ключу
    //for(int currWorker: Workers.valueSet()){//по значению   
        if(currWorker.getValue().equals("Иванов")) {
            System.out.println(currWorker);
        }
    }

    }  
}
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


public class Sem5Task2 {

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
/*
 Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь
 */

 