package com.company;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import  java.security.MessageDigest;

public class User {
    /**
     * Переменая содержащая имя пользователя
     */
    private String firstName;
    /**
     * Переменая содержащая фамилию пользователя
     */
    private String lastName;
    /**
     * Переменая содержащая id код пользователя
     */
    private String uuid;
    /**
     * Переменая содержащая MD5 has пикода этого пользователя
     */
    private byte pinHash[];
    /**
     * Переменая содержащая список аккаунтов этого пользователя
     */
    private ArrayList<Account> accounts;

    /**
     * Создание нового пользователя
     * @param firstName имя пользьвателя
     * @param lastName фамилия пользьвателя
     * @param pin пинкод для аккаунта пользьвателя
     * @param theBank объект банка в котором появился опльзователь
     */
    public User (String firstName, String lastName, String pin, Bank theBank){

        // указание имени юзера
        this.firstName = firstName;
        this.lastName = lastName;

        // Сокрытие пинкода MD5 Hash, для безопасности
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.print("Ошибка, нет криптографического алгоритма MD5");
            e.printStackTrace();
            System.exit(1);
        }

        // Получение нового уникального ID для пользователя
        this.uuid = theBank.getNewUserUUID();

        // Создание пустого списка аккаунтов
        this.accounts = new ArrayList<Account>();

        // Вывод сообщения в консоль
        System.out.printf("Новый пользователь %s, %s с ID %s создан.\n",
                lastName, firstName, uuid);
    }

    /**
     * Создание аккаунта для пользователя
     * @param anAcct - аккаунт для добавления
     */
    public void addAccount (Account anAcct) {
        this.accounts.add(anAcct);
    }

    /**
     * Метод возврата UUID пользователя
     * @return uuid
     */
    public String getUUID () {
        return  this.uuid;
    }

    /**
     * Проверка, соответствует ли данный pin истинному
     * pin пользователся
     * @param aPin pin на проверку
     * @return является ли пинкод действительным или нет
     */
    public  boolean validatePin(String aPin) {

        try {
            MessageDigest rd = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(rd.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.print("Ошибка, нет криптографического алгоритма MD5");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }
}
