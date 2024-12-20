package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import service.APIServices;
import com.github.javafaker.Faker;
import model.UserAccount;
import pages.AppHeaderPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тесты профиля")
@Feature("Профиль")
@Story("Переходы и взаимодействия в профиле")
@Owner("Lenok1998")
@Link(name = "HOMEWORK-1360 ChatGPT_03_MalyshevaES", type = "issue", url = "https://jira.autotests.cloud/browse/HOMEWORK-1360")
@Tag("automated")
public class ProfileTest extends WebDriverParams {
    private final Faker faker = new Faker(new Locale("en"));
    private final APIServices apiServices = new APIServices();
    private final List<UserAccount> testData = new ArrayList<>();
    private UserAccount account;

    @BeforeEach
    public void setUp() {
        account = new UserAccount();
        account.setEmail(faker.internet().emailAddress());
        account.setPassword(faker.internet().password());
        testData.add(account);
        apiServices.createAccount(account);
    }



    @AfterEach
    public void cleanUp() {
        apiServices.deleteAccounts(testData);
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Проверка перехода в личный кабинет по клику на \"Личный кабинет\"")
    @DisplayName("Проверка перехода в личный кабинет по клику на \"Личный кабинет\"")
    public void checkEnterProfileFromAppHeader() {
        open(MainPage.URL);
        new AppHeaderPage().clickProfileButtonByUnauthorizedUser().login(account.getEmail(), account.getPassword());
        ProfilePage profilePage = new AppHeaderPage().clickProfileButtonByAuthorizedUser();
        assertTrue(profilePage.isDisplayed());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Проверка перехода из личного кабинета в конструктор по клику на \"Конструктор\"")
    @DisplayName("Переход из личного кабинета в конструктор. Проверка перехода по клику на \"Конструктор\"")
    public void checkMovingFromProfileToBurgerBuilder() {
        open(MainPage.URL);
        new AppHeaderPage().clickProfileButtonByUnauthorizedUser().login(account.getEmail(), account.getPassword());
        MainPage mainPage = new AppHeaderPage().clickBuilderButton();
        assertTrue(mainPage.isDisplayed());
        assertTrue(mainPage.isAuthorisedUser());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Проверка перехода из личного кабинета в конструктор по клику на логотип \"Stellar Burgers\"")
    @DisplayName("Переход из личного кабинета в конструктор. Проверка перехода по клику на логотип \"Stellar Burgers\"")
    public void checkMovingFromProfileToLogo() {
        open(MainPage.URL);
        new AppHeaderPage().clickProfileButtonByUnauthorizedUser().login(account.getEmail(), account.getPassword());
        MainPage mainPage = new AppHeaderPage().clickAppLogo();
        assertTrue(mainPage.isDisplayed());
        assertTrue(mainPage.isAuthorisedUser());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Проверка выхода из аккаунта по кнопке \"Выйти\" в личном кабинете")
    @DisplayName("Выход из аккаунта. Проверка выхода по кнопке \"Выйти\" в личном кабинете")
    public void checkExitByExitButtonFromProfile() {
        open(MainPage.URL);
        new AppHeaderPage().clickProfileButtonByUnauthorizedUser().login(account.getEmail(), account.getPassword());
        ProfilePage profilePage = new AppHeaderPage().clickProfileButtonByAuthorizedUser();
        LoginPage loginPage = profilePage.exitButtonClick();
        assertTrue(loginPage.isDisplayed());
    }
}