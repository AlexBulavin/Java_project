package Lesson8.Task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    // Геттеры и сеттеры

    public static void main(String[] args) {
        // Создание списка объектов Person
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 30));
        persons.add(new Person("Charlie", 20));

        // Использование Comparator для сортировки по имени в алфавитном порядке
        Comparator<Person> nameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
/**
 * Сортирует указанный список в соответствии с порядком, определенным указанным компаратором. Все элементы в списке должны быть сравнимы между собой с использованием указанного компаратора (то есть, вызов c.compare(e1, e2) не должен вызывать исключение ClassCastException для любых элементов e1 и e2 в списке).
Эта сортировка гарантирует стабильность: равные элементы не будут переупорядочиваться в результате сортировки.
Указанный список должен быть изменяемым, но не обязательно изменяемым в размере.
*Тип параметров:
*класс объектов в списке

*Параметры:

***list - список, который нужно отсортировать.

*c - компаратор, определяющий порядок элементов в списке. Значение null указывает, что должен использоваться естественный порядок элементов.

*Исключения:

*ClassCastException - если в списке содержатся элементы, которые не могут быть сравнены между собой с использованием указанного компаратора.

*UnsupportedOperationException - если итератор списка, указанного в параметре list, не поддерживает операцию set.

*IllegalArgumentException - (необязательно) если обнаружено, что компаратор нарушает контракт Comparator.

*См. также:

*List.sort(Comparator)

*@implNote

*Эта реализация делегирует вызов методу List.sort(Comparator), используя указанный список и компаратор.
 */
        Collections.sort(persons, nameComparator);

        // Вывод отсортированного списка
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

        // То же самое через лямбда ф-ю
        Comparator<Person> nameComparator1 = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Collections.sort(persons, nameComparator1);

        // Вывод отсортированного списка
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
