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
    private UserInfo User;
    private DataGenerator AlfaUser;


    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
        AlfaUser = new DataGenerator();
        User = AlfaUser.GetUserInfo();

    }


    @Test
    void ShouldSendRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue(User.getCity());
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(AlfaUser.GetDate(4));
        form.$("[data-test-id=name] input").setValue(User.getName());
        form.$("[data-test-id=phone] input").setValue(User.getPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(AlfaUser.GetDate(5));
        form.$(".button").click();
        $(byText("Перепланировать")).waitUntil(visible, 15000);
        $("[data-test-id=replan-notification] button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

    }
}

