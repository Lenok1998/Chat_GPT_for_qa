package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AppHeaderPage {
    private final SelenideElement profileButton = $x(".//p[text()='Личный Кабинет']");
    private final SelenideElement builderButton = $x(".//p[text()='Конструктор']");
    private final SelenideElement appLogo = $x(".//div[@class='AppHeader_header__logo__2D0X2']");

    @Step("Клик на профиль для неавторизованного пользователя")
    public LoginPage clickProfileButtonByUnauthorizedUser() {
        profileButton.click();
        return new LoginPage();
    }

    @Step("Клик на профиль для авторизованного пользователя")
    public ProfilePage clickProfileButtonByAuthorizedUser() {
        profileButton.click();
        return new ProfilePage();
    }

    @Step("Клик на 'Конструктор' в AppHeader")
    public MainPage clickBuilderButton() {
        builderButton.click();
        return new MainPage();
    }

    @Step("Клик на лого приложения")
    public MainPage clickAppLogo() {
        appLogo.click();
        return new MainPage();
    }
}
