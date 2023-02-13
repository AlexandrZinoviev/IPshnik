import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; // доходы
        int spendings = 0; // расходы
        while (true){
            System.out.println("Выберите операцию и введите ее номер");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму рахода");
                        String expenseStr = scanner.nextLine();
                        int expense = Integer.parseInt(expenseStr);
                        spendings += expense;
                        break;
                    case 3:
                        int t1 = taxEarningMinusSpending(earnings, spendings);
                        int t2 = taxEarning(earnings);
                        if(t1 >= t2) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит:" + t2);
                            System.out.println("Налог на другой системе:" + t1);
                            System.out.println("Экономия:" + (t1 - t2));
                        } else {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит:" + t1);
                            System.out.println("Налог на другой системе:" + t2);
                            System.out.println("Экономия:" + (t2 - t1));
                        }
                        break;
                    default:

                }
            }

        }
        System.out.println("Программа завершена");
    }

    public static int taxEarningMinusSpending (int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if(tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarning (int earnings) {
        int tax2 = earnings * 6 / 100;
        return tax2;
    }
}