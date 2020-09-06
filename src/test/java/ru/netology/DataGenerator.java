package ru.netology;

import com.github.javafaker.Faker;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    public DataGenerator() {
    }

    private static String[] cities = new String[]{"Москва","Горно-Алтайск", "Саратов","Майкоп","Уфа","Петрозаводск"};

    public static UserInfo getUserInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(getCity(), faker.name().lastName()+" "+ faker.name().firstName(), faker.phoneNumber().phoneNumber());
    }

    public static String getDate(int days) {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = Date.valueOf((LocalDate.now().plusDays(days)));
        String meetingDate = formatter.format(date);
        return meetingDate;

    }

    private static String getCity(){
        int max = cities.length;
        int min = 0;
        int rnd = (int) ((Math.random()* (max-min)) +min);
        return cities[rnd];
    }

}
