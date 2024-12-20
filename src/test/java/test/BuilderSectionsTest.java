package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тесты конструктора")
@Feature("Конструктор")
@Story("Переходы к разделам")
@Link(name = "HOMEWORK-1360 ChatGPT_03_MalyshevaES", type = "issue", url = "https://jira.autotests.cloud/browse/HOMEWORK-1360")
@Owner("Lenok1998")
public class BuilderSectionsTest extends WebDriverParams {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Работают переходы к разделам - Булки, Соусы, Начинки")
    @DisplayName("Раздел 'Конструктор'. Работают переходы к разделам - Булки, Соусы, Начинки")
    @Tag("automated")
    public void jumpToIngredientsSection_auto() {
        open(MainPage.URL);
        MainPage mainPage = new MainPage();
        mainPage.clickFillingHeader();
        assertTrue(mainPage.fillingSectionSelected());
        mainPage.clickSauceHeader();
        assertTrue(mainPage.sauceSectionSelected());
        mainPage.clickBunHeader();
        assertTrue(mainPage.bunSectionSelected());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Описание теста: Работают переходы к разделам - Булки, Соусы, Начинки")
    @DisplayName("Раздел 'Конструктор'. Работают переходы к разделам - Булки, Соусы, Начинки")
    @Tag("manual")
    public void jumpToIngredientsSection() {
        step("Открыть главную страницу" + MainPage.URL);
        step("Клик на раздел 'Начинки'");
        step("Проверка что выбран раздел 'Начинки'");
        step("клик на раздел 'Соусы'");
        step("проверка что выбран раздел 'Соусы'");
        step("клик на раздел 'Булки'");
        step("проверка что выбран раздел 'Булки'");
    }
}
