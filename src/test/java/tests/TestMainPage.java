package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestMainPage extends TestBase{
    @Test
    @Tag("remote")
    @DisplayName("Проверить содержимое раздела новостей по фильтру")
    void mainPageTitleHaveText() {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
        });
        step("Принять cookie", () -> {
            mainPage.clickcookieButton();
        });
        step("Перейти в раздел Все новости", () -> {
            mainPage.clickMedia();
        });
        step("Нажать на фильтр тем", () -> {
             mainPage.clickFilterButton();
        });
        step("Проверить, что фильтр сработал и есть варианты для просмотра", () -> {
            mainPage.checkValueInSearchMedia();
        });

    }

    @Test
    @Tag("remote")
    @DisplayName("Поиск на главной находит в списке ответов вакансию QA")
    void searchVacancySuccessful() {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
        });
        step("Кликнуть в строку поиска",() -> {
            mainPage.clickInSearch();
        });
        step("Ввести qa",() -> {
            mainPage.inputValueInSearch("QA");
        });
        step("Проверить, что в выводе есть вакансии",() -> {
            mainPage.checkValueInSearch();
        });
    }

    @Test
    @Tag("remote")
    @DisplayName("Проверка наличия контактов главного офиса")
    void checkInfo() {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
        });
        step("Нажать кнопку Контакты", () -> {
            mainPage.clickContactInfo();
        });
        step("Главный офис должен иметь соответсвующий адрес", () -> {
            mainPage.checkValueInAddressBlockMainOffice();
        });
    }

    @ParameterizedTest(name = "Проверка наличия блоков с информацией локаль RUS: {0}")
    @Tag("remote")
    @ValueSource(strings = {"Агропромышленность",
            "Газовая индустрия",
            "Государственные программы",
            "Металлургия",
            "Нефть и химия",
            "Промышленность и транспорт",
            "Телеком",
            "ТНП и ритейл",
            "Финансовые институты",
            "Энергетика и ЖКХ"})
    void checkSolutionsBlock(String testSolutions) {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
        });
        step("Выполнить сверку наличия направления:", () -> {
            mainPage.checkBlockSolutions(testSolutions);
        });
    }

    @ParameterizedTest(name = "Проверка наличия блоков с информацией локали ENG: {0}")
    @Tag("remote")
    @ValueSource(strings = {"Company at a glance",
            "Mission and Values",
            "Management Team",
            "All Products & Services",
            "Technology Partners",
            "Quality Standards",
            "Contacts"})
    void checkSolutionsBlockENG(String testSolutions) {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
        });
        step("Переключить язык", () -> {
            mainPage.clickLocaleEng();
        });
        step("Выполнить сверку наличия направления для локали ENG:", () -> {
            mainPage.checkBlockSolutionsENG(testSolutions);
        });
    }


}
