package org.example;

import java.util.*;

/*
Задание

Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
//        phoneBook.put("Ivanov", List.of("8986", "8645", "138"));
//        phoneBook.put("Petrov", List.of("1356","44654654"));
//        phoneBook.put("Sidorov", List.of("4567", "78962"));
//        phoneBook.put("Lavrov", List.of("786433", "11242", "156498400", "5461613"));
//        phoneBook.put("Coy", List.of("17515", "15717"));

        menu(phoneBook);
    }
    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите фамилию: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phoneBook) {
        System.out.println("Введите фамилию: ");
        String name = scanner();
        System.out.println("Введите номер: ");
        String phone = scanner();
        List<String> number = new ArrayList<>();
        if (phoneBook.containsKey(name)){
            number = phoneBook.get(name);
            number.add(phone);

        } else {
            number.add(phone);
            phoneBook.put(name, number);
        }
        return phoneBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phoneBook);
                        break;
                    case "add":
                        add(phoneBook);
                        break;
                    case "all":
                        allBook(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}