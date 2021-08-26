package ru.yandex.market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ru.yandex.market.SelenideYandex;
import pages.ru.yandex.market.SelenideYandexMarket;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class Tests extends BaseTest {

    @Test
    public void yandexPageTest() {
        SelenideYandex selenideYandex = new SelenideYandex();
        open("https://yandex.ru/");
        selenideYandex.goToYandexMarket();
        switchTo().window(1);
        SelenideYandexMarket selenideYandexMarket = new SelenideYandexMarket();
        selenideYandexMarket.openElectronicSection();
        selenideYandexMarket.openSmartphonesSection();
        selenideYandexMarket.changeRegion("Москва");
        selenideYandexMarket.selectSmartphoneBrand("iPhone");
        selenideYandexMarket.show12Items();
        while(selenideYandexMarket.isOneMorePage()); {
            Assertions.assertEquals(true, selenideYandexMarket.checkContainsBrand("iPhone"));
        }


    }



}
