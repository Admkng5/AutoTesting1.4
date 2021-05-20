package pages.ru.yandex.market;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideYandexMarket {

    private String brandName;

    private SelenideElement electronicLink = $(By.xpath("//a[contains(span,'Электроника')]"));
    private SelenideElement smartphonesLink = $(By.xpath("//a[text()='Смартфоны']"));
    private SelenideElement regionElement = $(By.xpath("//*[@title='Регион']"));
    private SelenideElement inputRegionName = $(By.xpath("//input[@placeholder='Укажите другой регион']"));
    private SelenideElement selectorRegionFromList = $(By.xpath("//a/span/b"));
    private SelenideElement continueWithSelectedRegion = $(By.xpath("//span[contains(text(), 'Продолжить с новым регионом')]"));
    private SelenideElement buttonShowNumberItems = $(By.xpath("//span/span[contains(.,'Показывать по')]/ancestor::button/.."));
    private SelenideElement buttonShow12Elements = $(By.xpath("//button[text()='Показывать по 12']"));
    private String smartphoneName = "//h3[@data-zone-name='title']/a";
    private String anotherPage = "//a[@aria-label='Следующая страница']";

    public void openElectronicSection() {
        electronicLink.click();
    }

    public void openSmartphonesSection() {
        smartphonesLink.click();
    }

    public void selectSmartphoneBrand(String brandName) {
        $(By.xpath("//span[text()='"+brandName+"']/..")).shouldBe(Condition.visible).click();
    }

    public void changeRegion(String regionName) {
        regionElement.click();
        inputRegionName.setValue(regionName);
        selectorRegionFromList.click();
        continueWithSelectedRegion.click();
    }

    public void show12Items() {
        buttonShowNumberItems.click();
        buttonShow12Elements.shouldBe(and("Clickable", visible, enabled)).click();
    }

    public boolean checkContainsBrand(String smartphone) {
        $(By.xpath(smartphoneName)).should(exist);
        return $$(By.xpath(smartphoneName)).stream()
                .map(SelenideElement::getText)
                .allMatch(x -> x.contains(smartphone));

    }

    public boolean isOneMorePage() {
        $(By.xpath(smartphoneName)).shouldBe(and("Clickable", visible, enabled));
            if ($(By.xpath(anotherPage)).exists()) {
                $(By.xpath(anotherPage)).click();
                return true;
        }
        return false;
    }

}