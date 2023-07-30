import java.util.*;
//4. Разработайте программу, которая выбросит Exception,
//        когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

public class Task_4 {
    public static void main(String[] args) {
        try {
            String input = getStringInput();
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя");
            }
            System.out.println("Введенная строка: " + input);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        return input;
    }
}
