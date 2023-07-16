package Student5;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        System.out.println("Привет, ты хочешь сыграть в игру?");
        System.out.print("Ответ: ");
        String name = scanner.nextLine();

        String no = "Нет";

        if (name.equals(no)) {
            System.out.println("Хммм...");
            System.out.println("Я надеялся, что ты со мной поиграешь.");
            return;
        }

        System.out.println();
        System.out.println("Я вижу ты любитель поиграть.");
        System.out.println();
        System.out.println("Правила игры:");
        System.out.println("Я загадал случайное число от 1 до 100 включительно.");
        System.out.println("Твоя задача отгадать это число.");
        System.out.println("P.S. количество попыток не ограниченно.");
        System.out.println();
        System.out.println("Введите целое число:");

        int attemptsCount = 0;

        while (true) {
            attemptsCount++;

            int inputNumber = scanner.nextInt();

            if (randomNumber > inputNumber) {
                System.out.println("Число меньше загаданного.");
            } else if (randomNumber < inputNumber) {
                System.out.println("Число больше загаданного.");
            } else {
                System.out.println("Ура. Вы отгадали число.");
                break;
            }

            System.out.println("Введите число заново:");
        }

        System.out.printf("Вы использовали %d попыток.", attemptsCount);
    }
}