package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String TITLE_TEXT = "IBS — ведущая российская IT-сервисная компания";
    private final String MAIN_OFFICE_ADDRESS = "Россия, 127018, Москва, ул. Складочная, д. 3, стр. 1";

    private SelenideElement
            searchMainpage = $x("//div[@class='header-search']"),
            inputSearch =  $(byName("q")),
            mediaButton = $(byText("Все новости")),
            cookieButton = $(".button--white"),
            selectListNews = $("a.tag:nth-child(3)"),
            localeEng = $x("//div[a='Eng']"),
            ContactLabel = $x("//div[a='Контакты']"),
            mainOfficeAddress = $(".contacts-map-popup");
    private ElementsCollection
            listSearchMedia =$$(".media-item__tag"),
            listSearch = $$x("//a[@class='tab']");

    public MainPage openPage() {
        open("https://ibs.ru/");
        $("title").shouldHave(attribute("text", TITLE_TEXT));
        return this;
    }

    public MainPage clickInSearch(){
        searchMainpage.click();
        return this;
    }

    public MainPage clickLocaleEng(){
        localeEng.click();
        return this;
    }

    public MainPage clickContactInfo(){
        ContactLabel.click();
        return this;
    }

    public MainPage clickMedia(){
        mediaButton.scrollIntoView(true);
        mediaButton.click();
        return this;
    }

    public MainPage clickFilterButton(){
        selectListNews.click();
        return this;
    }

    public MainPage clickcookieButton(){
        cookieButton.click();
        return this;
    }

    public MainPage checkValueInSearch(){
        System.out.printf(String.valueOf(listSearch.size()));
        listSearch.shouldHave(CollectionCondition.containExactTextsCaseSensitive("вакансии (1)"));
        return this;
    }

    public MainPage checkValueInSearchMedia(){
        System.out.printf(String.valueOf(listSearchMedia.size()));
        listSearchMedia.shouldHave(sizeGreaterThan(0));
        listSearchMedia.shouldHave(CollectionCondition.containExactTextsCaseSensitive("МЕРОПРИЯТИЯ"));
        return this;
    }

    public MainPage checkValueInAddressBlockMainOffice(){
        mainOfficeAddress.shouldHave(partialText(MAIN_OFFICE_ADDRESS));
        return this;
    }

    public MainPage inputValueInSearch(String value) {
        inputSearch.setValue(value);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }


    public void checkBlockSolutions(String testSolutions) {
        $$x("//a[@class='main-solution']")
                .filter(visible).shouldHave(CollectionCondition.itemWithText(testSolutions));
    }

    public void checkBlockSolutionsENG(String testSolutions) {
        $$x("//span[@class='card__title']")
                .filter(visible)
                .shouldHave(CollectionCondition.itemWithText(testSolutions));
    }



}
