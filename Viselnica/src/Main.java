import java.util.Random;
import java.util.Scanner;

public class Main {
    // Список слов
    private static final String[] WORDS = {"яблоко", "машина", "процессор", "ноутбук", "стул"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int lives = 6;
        boolean wordGuessed = false;

        while (lives > 0 && !wordGuessed) {
            System.out.println("Слово: " + String.valueOf(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char leter = sc.nextLine().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == leter) {
                    guessedWord[i] = leter;
                    found = true;
                }
            }

            if (!found) {
                lives--;
                draw(lives);
                System.out.println("Буква '" + leter + "' отсутствует в слове.");
            }

            if (String.valueOf(guessedWord).equals(word)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("Вы угадали: " + word);
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + word);
        }

        sc.close();
    }

    private static void draw(int lives) {
        switch (lives) {
            case 5:
                System.out.println(" O ");
                break;
            case 4:
                System.out.println(" O ");
                System.out.println(" | ");
                break;
            case 3:
                System.out.println(" O ");
                System.out.println("/| ");
                break;
            case 2:
                System.out.println(" O ");
                System.out.println("/|\\ ");
                break;
            case 1:
                System.out.println(" O ");
                System.out.println("/|\\");
                System.out.println("/ ");
                break;
            case 0:
                System.out.println(" O ");
                System.out.println("/|\\");
                System.out.println("/ \\");
                System.out.println("Вы повешены!");
                break;
            default:
                System.out.println();
        }
    }
}
