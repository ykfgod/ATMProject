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
}
