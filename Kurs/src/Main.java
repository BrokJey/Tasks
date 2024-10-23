import java.util.Scanner;
public class Main {
    private static final double EUR_TO_RUB = 104.24; // Евро в Доллары
    private static final double GBP_TO_RUB = 125.42; // Фунт в Доллары
    private static final double JPY_TO_RUB = 0.63; // Йена в Доллары
    private static final double USD_TO_RUB = 96.70; // Рубль в Доллары
    private static final double CNY_TO_RUB = 13.54;  // Юань в Доллары

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите валюту для конвертации:");
        System.out.println("1 - Евро (EUR)");
        System.out.println("2 - Фунт (GBP)");
        System.out.println("3 - Йена (JPY)");
        System.out.println("4 - Доллар (USD)");
        System.out.println("5 - Юань (CNY)");
        System.out.print("Введите номер валюты: ");
        int Choice = sc.nextInt();
        if (Choice > 5 || Choice <1){
            System.out.println("Ошибка. Введена не правильная валюта");
        }

        System.out.print("Введите сумму: ");
        double amount = sc.nextDouble();
        double InRUB = ToRUB(Choice, amount);

        System.out.println("Конвертация в другие валюты:");
        System.out.println("Сумма в USD:" + Math.round(convertFromRUB(InRUB, USD_TO_RUB) * 100.0)/100.0);
        System.out.println("Сумма в EUR:" + Math.round(convertFromRUB(InRUB, EUR_TO_RUB) * 100.0)/100.0);
        System.out.println("Сумма в GBP:" + Math.round(convertFromRUB(InRUB, GBP_TO_RUB) * 100.0)/100.0);
        System.out.println("Сумма в JPY:" + Math.round(convertFromRUB(InRUB, JPY_TO_RUB) * 100.0)/100.0);
        System.out.println("Сумма в RUB:" + Math.round(InRUB)*100.0/100.0);
        System.out.println("Сумма в CNY:" + Math.round(convertFromRUB(InRUB, CNY_TO_RUB) * 100.0)/100.0);

        sc.close();
    }

    private static double ToRUB(int Choice, double amount) {
        switch (Choice) {
            case 1:
                return amount * EUR_TO_RUB;
            case 2:
                return amount * GBP_TO_RUB;
            case 3:
                return amount * JPY_TO_RUB;
            case 4:
                return amount * USD_TO_RUB;
            case 5:
                return amount * CNY_TO_RUB;
            default:
                return 0;
        }
    }

    private static double convertFromRUB(double InRUB, double money) {
        return InRUB / money;
    }
}