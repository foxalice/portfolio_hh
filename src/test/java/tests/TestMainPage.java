package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static io.qameta.allure.Allure.step;

public class TestMainPage extends TestBase{

    @Test
    @Tag("remote")
    @DisplayName("Главная страница имеет заголовок")
    void mainPageTitleHaveText() {
        step("Открыть главную страницу и выполнить сверку", () -> {
            mainPage.openPage();
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
        step("Проверить, что в выводе есть вакансия",() -> {
            mainPage.checkValueInSearch();
        });
    }

    static Stream<Arguments> selenideLocaleDataProviderEN() {
        return Stream.of(
                Arguments.of(List.of(
                        "Company at a glance",
                        "Mission and Values",
                        "Management Team",
                        "All Products & Services",
                        "Technology Partners",
                        "Quality Standards",
                        "Contacts"
                ))
        );
    }

    @MethodSource("selenideLocaleDataProviderEN")
    @ParameterizedTest(name = "Для локали EN отображаются кнопки меню {0} ")
    @Tag("BLOCKER")
    void siteShouldContainAllOfButtonsForGivenLocale(
            List<String> buttons
    ) {
            mainPage.openPage();
            mainPage.clickLocaleEng();
        $$x("//span[@class='card__title']")
                .filter(visible)
                .shouldHave(texts(buttons));

    }

    static Stream<Arguments> selenideLocaleDataProviderRU() {
        return Stream.of(
                Arguments.of(List.of(
                        "Агропромышленность",
                        "Газовая индустрия",
                        "Государственные программы",
                        "Металлургия",
                        "Нефть и химия",
                        "Промышленность и транспорт",
                        "Телеком",
                        "ТНП и ритейл",
                        "Финансовые институты",
                        "Энергетика и ЖКХ"
                ))
        );
    }

    @MethodSource("selenideLocaleDataProviderRU")
    @ParameterizedTest(name = "Для локали RUS отображаются кнопки меню {0}")
    @Tag("BLOCKER")
    void siteShouldContainAllOfButtonsForGivenLocaleRU(
            List<String> buttons
    )
        {
        mainPage.openPage();

        $$x("//a[@class='main-solution']")
                .filter(visible)
                .shouldHave(texts(buttons));
    }

}
