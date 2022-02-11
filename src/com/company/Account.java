package com.company;

import java.util.ArrayList;

public class Account {
    /**
     * Переменая содержащая имя аккаунта
     */
    private  String name;
    /**
     * Переменая содержащая баланс аккаунта
     */
    private  double balance;
    /**
     * Переменая содержащая ID номер аккаунта
     */
    private  String uuid;
    /**
     * Переменая содержащая объект User владельца этого аккаунта
     */
    private  User holder;
    /**
     * Переменая содержащая список транзакций этого аккаунта
     */
    private ArrayList<Transaction> transactions;
}
