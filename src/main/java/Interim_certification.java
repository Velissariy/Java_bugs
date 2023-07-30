
//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//        Фамилия Имя Отчество дата
//        рождения номер
//        телефона пол
//        Форматы данных:
//        фамилия, имя, отчество - строки
//        дата
//        рождения - строка формата dd.mm.yyyy
//        номер телефона - целое беззнаковое число без форматирования
//        пол - символ латиницей w или m.
//        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
//        вернуть код ошибки, обработать его и показать пользователю сообщение,
//        что он ввел меньше и больше данных, чем требуется.
//        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//        Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//        Можно использовать встроенные типы java и создать свои.
//        Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//        в него в одну строку должны записаться полученные данные, видa
//<Фамилия><Имя><Отчество><дата
//рождения> <номер
//телефона><пол>
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//        Не забудьте закрыть соединение с файлом.
//        При возникновении проблемы с чтением-записью в файл,
//        исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Interim_certification {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите данные (Фамилия Имя Отчество датарождения(в формате dd.mm.yyyy) номертелефона пол(w или m): ");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            LocalDate birthDate = parseDate(data[3]);
            long phoneNumber = parsePhoneNumber(data[4]);
            char gender = parseGender(data[5]);

            String fileName = lastName + ".txt";
            String fileContent = lastName + firstName + patronymic + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                    " " + phoneNumber + gender;

            writeToFile(fileName, fileContent);
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Некорректный формат даты");
        }
    }

    public static long parsePhoneNumber(String phoneNumberStr) {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный формат номера телефона");
        }
    }

    public static char parseGender(String genderStr) {
        if (genderStr.length() != 1 || (!genderStr.equalsIgnoreCase("w") && !genderStr.equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("Некорректное значение пола");
        }
        return genderStr.charAt(0);
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
        }
    }
}

