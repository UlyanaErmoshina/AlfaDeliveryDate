package ru.netology;

import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

class AlfaDateTest {

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void ShouldSendRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue(faker.address().cityName());
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = Date.valueOf((LocalDate.now().plusDays(4)));
        String meetingDate = formatter.format(date);
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(meetingDate);
        form.$("[data-test-id=name] input").setValue(faker.name().fullName());
        form.$("[data-test-id=phone] input").setValue(faker.phoneNumber().cellPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

        date = Date.valueOf((LocalDate.now().plusDays(5)));
        meetingDate = formatter.format(date);
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(meetingDate);
        form.$(".button").click();
        $(byText("Перепланировать")).waitUntil(visible, 15000);
        $("[data-test-id=replan-notification] button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

    }
}

