import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bestAttempts = 0;

        System.out.println("Игра \"Кинуть кости\"");
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        while (true) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;

            while (true) {

                System.out.print("Введи число или RESULT: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("RESULT")) {
                    System.out.println("Текущее количество попыток: " + attempts);

                    if (bestAttempts == 0) {
                        System.out.println("Лучшей игры пока нет.");
                    } else {
                        System.out.println("Количество попыток в лучшей игре: " + bestAttempts);
                    }

                    continue;
                }

                int userNumber;

                try {
                    userNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введи число от 1 до 100.");
                    continue;
                }

                if (userNumber < 1 || userNumber > 100) {
                    System.out.println("Число должно быть от 1 до 100.");
                    continue;
                }

                attempts++;

                if (userNumber < secretNumber) {
                    System.out.println(
                            "Я сам в шоке, но, загаданное число больше, брат"
                    );
                } else if (userNumber > secretNumber) {
                    System.out.println(
                            "Не ожидал от тебя такого. Загаданное число меньше, брат"
                    );
                } else {
                    System.out.println(
                            "Поздравляю! Ты угадал число: " + secretNumber
                    );
                    System.out.println(
                            "Количество попыток: " + attempts
                    );

                    if (bestAttempts == 0 || attempts < bestAttempts) {
                        bestAttempts = attempts;
                    }

                    System.out.println(
                            "Количество попыток в лучшей игре: " + bestAttempts
                    );

                    break;
                }
            }

            System.out.println();
            System.out.println("Новая игра началась!");
        }
    }
}