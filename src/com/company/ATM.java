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
    }
}
