package ru.netology.web;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class CallbackTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;

    }

    @Test
    public void shouldRegisteredTest() {
        open("http://localhost:9999");
        element(By.name("name")).setValue("Руслан Скитович");
        element(By.name("phone")).setValue("+79150000000");
        element(By.className("checkbox__box")).click();
        element(By.className("button__text")).click();
        element("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    public void shouldShowErrorWithoutNameTest() {
        open("http://localhost:9999");
        element(By.name("phone")).setValue("+79150000000");
        element(By.className("checkbox__box")).click();
        element(By.className("button__text")).click();
        element("[data-test-id=name] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldShowErrorWithoutTelephoneTest() {
        open("http://localhost:9999");
        element(By.name("name")).setValue("Руслан Скитович");
        element(By.className("checkbox__box")).click();
        element(By.className("button__text")).click();
        element("[data-test-id=phone] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldShowErrorCheckBoxTest() {
        open("http://localhost:9999");
        element(By.name("phone")).setValue("+79150000000");
        element(By.name("name")).setValue("Руслан Скитович");
        element(By.className("button__text")).click();
        element(".form-field .input_invalid").should(exist);
        element(".form-field .checkbox__text").shouldHave(text("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));


    }

}
