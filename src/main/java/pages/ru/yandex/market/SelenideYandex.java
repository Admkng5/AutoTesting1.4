package pages.ru.yandex.market;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$x;

public class SelenideYandex {

    private String marketLink = "//a[@data-id='market']";

    protected WebDriver wd;

    public void goToYandexMarket() {
        $x(marketLink).click();
    }


}
