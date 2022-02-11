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
     * Создание конструктора для User
     */
    public User (String firstName, String lastName, String pin, Bank theBank){

        // указание имени юзера
        this.firstName = firstName;
        this.lastName = lastName;

        // Сокрытие пинкода MD5 has, для безопасности
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.print("Ошибка, нет криптографического алгоритма MD5");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
