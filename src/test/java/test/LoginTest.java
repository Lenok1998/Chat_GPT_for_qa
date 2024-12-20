package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import service.APIServices;
import com.github.javafaker.Faker;
import model.UserAccount;
import pages.AppHeaderPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тесты входа в систему")
@Feature("Вход в систему")
@Story("Вход пользователя")
@Tag("automated")
@Link(name = "HOMEWORK-1360 ChatGPT_03_MalyshevaES", type = "issue", url = "https://jira.autotests.cloud/browse/HOMEWORK-1360")
@Owner("Lenok1998")
public class LoginTest extends WebDriverParams {
    private final Faker faker = new Faker(new Locale("en"));
    private final APIServices apiServices = new APIServices();
    private final List<UserAccount> testData = new ArrayList<>();
    private UserAccount account;

    @BeforeEach
    public void setUp() {
        setName(faker.name().firstName());
        // Создаем экземпляр UserAccount
        UserAccount account = new UserAccount();

        // Устанавливаем имя с помощью Faker
        String generatedName = faker.name().name();
        account.setName(generatedName);
        String generatedEmail = faker.internet().emailAddress();
        account.setEmail(generatedEmail);
        String generatedPassword = faker.internet().password();
        account.setPassword(generatedPassword);
    }

    private void setName(String s) {
    }

    @AfterEach
    public void cleanUp() {
        apiServices.deleteAccounts(testData);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Пользователь может войти в систему с действительными учетными данными через кнопку 'Войти в аккаунт' на главной странице.")
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void loginFromMainPageByLoginButton() {
        open(MainPage.URL);
        MainPage mainPage = new MainPage().clickLoginButton().login(account.getEmail(), account.getPassword());
        assertTrue(mainPage.isAuthorisedUser());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Пользователь может войти в систему с действительными учетными данными через кнопку 'Личный кабинет' на главной странице.")
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginFromMainPageByProfileButton() {
        open(MainPage.URL);
        MainPage mainPage = new AppHeaderPage().clickProfileButtonByUnauthorizedUser().login(account.getEmail(), account.getPassword());
        assertTrue(mainPage.isAuthorisedUser());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Пользователь может войти в систему с действительными учетными данными через кнопку в форме регистрации.")
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPageByLoginButton() {
        open(RegistrationPage.URL);
        MainPage mainPage = new RegistrationPage().loginButtonClick().login(account.getEmail(), account.getPassword());
        assertTrue(mainPage.isAuthorisedUser());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Пользователь может войти в систему с действительными учетными данными через кнопку в форме восстановления пароля.")
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryPageByLoginButton() {
        open(PasswordRecoveryPage.URL);
        MainPage mainPage = new PasswordRecoveryPage().loginButtonClick().login(account.getEmail(), account.getPassword());
        assertTrue(mainPage.isAuthorisedUser());
    }
}
