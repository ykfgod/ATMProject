package com.company;
import  java.util.Date;

public class Transaction {
    /**
     * Переменая содержащая сумму этой транзакции
     */
    private  double amount;
    /**
     * Переменая содержащая дату и время этой транзакции
     */
    private  Date timestamp;
    /**
     * Переменая содержащая описание этой транзакции
     */
    private  String memo;
    /**
     * Переменая содержащая имя аккаунта на которм совершена транзакция
     */
    private  Account inAccount;

    /**
     * Создание новой транзакции
     * @param amount сумма транзакции;
     * @param inAccount аккаунт, которому пренадлежит транзакция
     */
    public  Transaction (double amount, Account inAccount) {

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";

    }

    /**
     * Создание новой транзакции (конструктор 2-ого типа)
     * @param amount сумма транзакции;
     * @param inAccount аккаунт, которому пренадлежит транзакция
     * @param memo описание для транзакции
     */
    public  Transaction (double amount, String memo, Account inAccount) {

        // объявление двух аргументов конструктора
        this(amount, inAccount);

        // объявление сообщения
        this.memo = memo;
    }
}
