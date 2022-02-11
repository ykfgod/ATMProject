package com.company;

import java.util.ArrayList;

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
}
