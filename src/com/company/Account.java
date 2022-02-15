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
    private  String uuid;
    /**
     * Переменая содержащая объект User владельца этого аккаунта
     */
    private  User holder;
    /**
     * Переменая содержащая список транзакций этого аккаунта
     */
    private ArrayList<Transaction> transactions;

    /**
     * Создание нового аккаунта
     * @param name - имя для аккаунта
     * @param holder - объект User, который владеет этим аккаунтом
     * @param theBank - банк, в котором зарегестирован аккаунт
     */

    public Account(String name, User holder, Bank theBank) {

        // Установка имени аккаунта и владельца
        this.name = name;
        this.holder = holder;

        // Получение нового UUID для аккаунта
        this.uuid = theBank.getNewAccountUUID();

        // Инициализация транзакций
        this.transactions = new ArrayList<Transaction>();

        // Добавление к владельцу и банку списков
        holder.addAcount(this);
        theBank.addAccount(this);
    }
}
