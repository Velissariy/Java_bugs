import java.util.*;
//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//        и возвращает введенное значение.
//        Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
//        необходимо повторно запросить у пользователя ввод данных.
public class Task_1 {
    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Введенное число: " + number);
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0.0f;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Введите дробное число: ");
            String input = scanner.nextLine();

            try {
                number = Float.parseFloat(input);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введено некорректное значение. Повторите ввод.");
            }
        }

        return number;





    }
}
