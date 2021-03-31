package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class OrderTest {
    @Test
    void shouldSubmitRequest() {
        open("http://0.0.0.0:9999/");
        ElementsCollection inputs = $$ (".input__control");
        inputs.find(Condition.attribute("type","text")).setValue("Пупкин Вася");
        inputs.find(Condition.attribute("type","tel")).setValue("+790977777777");
        $(".checkbox__box").click();
        $(".button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
