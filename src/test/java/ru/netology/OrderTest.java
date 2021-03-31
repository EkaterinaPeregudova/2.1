package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void shouldSubmitRequest() {
        open("http://0.0.0.0:9999/");
    SelenideElement form =$("[data-test-id=callback-form]");
    form.$("[data-test-id=name] input").setValue("Василий");
    form.$("[data-test-id=phone] input").setValue("+79270000000");
    form.$("[data-test-id=agreement]").click();
    form.$("[data-test-id=submit]").click();
    $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}