package Lesson6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class lesson1 {
    /*
     * 1. Создайте HashSet, заполните его следующими числами: {1, 2, 30000, 2, 4, 5000, 6, 3}. Распечатайте содержимое данного множества.
     */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));//Преобразовали в List

        // set.add(1); set.add(2); set.add(30000);
        // set.add(2); set.add(4);set.add(5000); set.add(6);
        System.out.println(set); // []

        LinkedHashSet<Integer> l_set = new LinkedHashSet<>(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));//Выводит в порядке заполнения
        System.out.println(l_set); // []
        TreeSet<Integer> t_set = new TreeSet<>(Arrays.asList(1, 2, 30000, 2, 4, 5000, 6, 3));//Сортирует вывод от минимального к максимальному
        System.out.println(t_set); // []
    
    }
}
