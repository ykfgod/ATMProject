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
     *  Конструктор для создания объекта Bank с пустым литом
     *  пользователей и аккаунтов
     * @param name - название банка
     */
    public  Bank(String name) {

        this.name= name;
        this.user = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount (Account anAcct) {
        this.accounts.add(anAcct);
    }

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
     * Создание нового юзера банка
     * @param firstName Имя юзера
     * @param lastName Фамилия юзера
     * @param pin Пинкод юзера
     * @return новый объект Юзер
     */
    public User addUser(String firstName, String lastName, String pin) {

        // создание нового объекта User и добавление его в наш списков
        User newUser = new User(firstName, lastName, pin, this);
        this.user.add(newUser);

        // создание сохраненного аккаунта ждя пользователся и добавление User и Bank account списков
        Account newAccount = new Account("Сохранение", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    /**
     *  Получение объекта User которому принадлежат userID и pin
     *  если они верные.
     * @param userID UUID пользователся для логина
     * @param pin Пинкод пользователся
     * @return объект User если авторизация верная или
     * возврат NULL если не верная
     */
    public User userLogin(String userID, String pin) {

           // поиск юзера в списке
           for (User u : this.user) {

               // проверка ID пользователя на правельность
               if (u.getUUID().compareTo(userID) == 0 &&
               u.validatePin(pin)) {
                   return u;
               }
           }

           // если не найден пользователь или введен не корректный
           // пинкод возвращаем пусто значение.
           return  null;
    }
}
