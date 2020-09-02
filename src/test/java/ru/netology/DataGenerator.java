package ru.netology;

import com.github.javafaker.Faker;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {

    public DataGenerator() {
    }

    public static UserInfo GetUserInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(faker.address().cityName(), faker.name().fullName(), faker.phoneNumber().cellPhone());
    }
    public String GetDate(int days) {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = Date.valueOf((LocalDate.now().plusDays(days)));
        String meetingDate = formatter.format(date);
        return meetingDate;

    }

}
