import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String letters_up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String letters_down = "abcdefghtjklmnopqrstuvwxyz";
    private static final String numbers = "1234567890";
    private static final String special = "!@#$%^&*()_-+=<>/\\|'[]{};:.,?№`";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введите размер пароля от 8 до 12 символов: ");
        int length = sc.nextInt();

        if (length<8 || length>12){
            System.out.println("Ошибка. Введите правильный размер");
            return;
        }

        String password = Gen(length, rand);
        System.out.println("Пароль: "+password);

        sc.close();
    }

    private static String Gen(int size, Random random) {
        String allSymbols = letters_up + letters_down + numbers + special;
        String password = "";

        password+=letters_up.charAt(random.nextInt(letters_up.length()));
        password+=letters_down.charAt(random.nextInt(letters_down.length()));
        password+=numbers.charAt(random.nextInt(numbers.length()));
        password+=special.charAt(random.nextInt(special.length()));

        for (int i = 4; i<=size;i++) {
            password+=allSymbols.charAt(random.nextInt(allSymbols.length()));
        }
        return shuffle(password, random);
    }

    private static String shuffle(String str, Random random) {
        char[] symbols = str.toCharArray();
        for (int i = symbols.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = temp;
        }
        return new String(symbols);
    }
}