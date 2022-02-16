package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    /**
     * Переменая содержащая название банка
     */
    private String name;
    /**
     * Переменая содержащая список объектов пользвателей банка
     */
    private ArrayList<User> user;
    /**
     * Переменая содержащая список объектов аккаунтов банка
     */
    private  ArrayList<Account> accounts;

    /**
     * Генерация уникального универсального ID для пользователя
     * @return uuid
     */
    public String getNewUserUUID() {

        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        // цикл пока не получится уникальный ID
        do {
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer)rng.nextInt(10)).toString();

            }

            nonUnique = false;
            for (User u : this.user) {
                 if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                 }
            }
        } while (nonUnique);

        return uuid;
    }

    /**
     * Генерация уникального универсального ID для аккаутна
     * @return uuid
     */
    public String getNewAccountUUID() {
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        // цикл пока не получится уникальный ID
        do {
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer)rng.nextInt(10)).toString();

            }

            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    /**
     * Добваление аккаунта
     * @param anAcct аккаунт для добавления
     */
    public  void addAccount (Account anAcct) {
        this.accounts.add(anAcct);
    }

}
