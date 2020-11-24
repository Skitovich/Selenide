package ru.netology.web;

import com.codeborne.selenide.conditions.CssClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    public void shouldRegisteredTest() {
        open("http://localhost:9999");
        $(By.name("name")).setValue("Руслан Скитович");
        $(By.name("phone")).setValue("+79150000000");
        $(By.className("checkbox__box")).click();
        $(By.className("button__text")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    public void shouldShowErrorTest() {
        open("http://localhost:9999");
        $(By.name("phone")).setValue("+79150000000");
        $(By.className("button__text")).click();
        $("[class=input__sub]").shouldHave(exactText("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldShowErrorCheckBoxTest() {
        open("http://localhost:9999");
        $(By.name("phone")).setValue("+79150000000");
        $(By.name("name")).setValue("Руслан Скитович");
        $(By.className("button__text")).click();
        $("[input_invalid]").exists();

    }
}

