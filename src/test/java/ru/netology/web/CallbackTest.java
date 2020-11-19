package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    public void shouldTest() {
        open("http://localhost:9999");
        $(By.name("name")).setValue("Руслан Скитович");
        $(By.name("phone")).setValue("+79150000000");
        $(By.className("checkbox__box")).click();
        $(By.className("button__text")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
