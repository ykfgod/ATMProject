package com.company;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        // инисиализация сканера
        Scanner sc = new Scanner(System.in);

        // инициализация банка
        Bank theBank = new Bank("Bank of America");

        // создание пользователся, который также создает
        // сохранение аккаунтов
        User aUser = theBank.addUser("Ярослав", "Шаньгин", "1234");

        // создание проверочного аккаунта для
        Account newAccount = new Account("Проверка", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

            // оставаться в меню безсрочно пока успешная
            // авторизация.
            curUser = ATM.mainMenuPrompt(theBank, sc);

            ATM.printUserMenu(curUser, sc);

        }
    }

    /**
     * Напчатать логин меню банкомата
     * @param theBank - объект Bank чей аккаунт используется
     * @param sc - объект Scanner для ввода пользователем
     *           ID и ПИН-кода
     * @return состояние авторизации User
     */
    public static User mainMenuPrompt (Bank theBank, Scanner sc) {

        // инициализация переменных
        String userID;
        String pin;
        User authUser;

        //
        do {

            System.out.printf("\n\nДобро пожаловать в %s\n\n", theBank.getName());
            System.out.print("Введите ID пользователся");
            userID = sc.nextLine();
            System.out.print("Введите ПИН-код: ");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Не правельно введен ID или ПИН-код. " +
                        "Пожалуйста попробуйте еще раз.");
            }
        } while (authUser == null); // продолжение цикла
                                    // пока успешно введен ID и ПИН-код
        return authUser;
    }
}
