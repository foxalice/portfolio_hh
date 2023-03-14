package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class mainPage {
    private final String TITLE_TEXT = "IBS — ведущая российская IT-сервисная компания";

    private SelenideElement
            searchMainpage = $x("//div[@class='header-search']"),
            inputSearch =  $(byName("q")),
            mediaButton = $(byText("Все новости")),
            cookieButton = $(".button--white"),
            selectListNews = $("a.tag:nth-child(3)"),
            localeEng = $x("//div[a='Eng']");
    private ElementsCollection
            listSearchMedia =$$(".media-item__tag"),
            listSearch = $$x("//a[@class='tab']");

    public mainPage openPage() {
        open("https://ibs.ru/");
        $("title").shouldHave(attribute("text", TITLE_TEXT));
         return this;
    }

    public mainPage clickInSearch(){
        searchMainpage.click();
        return this;
    }

    public mainPage clickLocaleEng(){
        localeEng.click();
        return this;
    }

    public mainPage clickMedia(){
        mediaButton.scrollIntoView(true);
        mediaButton.click();
        return this;
    }

    public mainPage clickFilterButton(){
        selectListNews.click();
        return this;
    }

    public mainPage clickcookieButton(){
        cookieButton.click();
        return this;
    }

    public mainPage checkValueInSearch(){
        System.out.printf(String.valueOf(listSearch.size()));
        listSearch.shouldHave(CollectionCondition.containExactTextsCaseSensitive("вакансии (1)"));
    return this;
    }

    public mainPage checkValueInSearchMedia(){
        System.out.printf(String.valueOf(listSearchMedia.size()));
        listSearchMedia.shouldHave(sizeGreaterThan(0));
        listSearchMedia.shouldHave(CollectionCondition.containExactTextsCaseSensitive("МЕРОПРИЯТИЯ"));
    return this;
    }

    public mainPage inputValueInSearch(String value) {
        inputSearch.setValue(value);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }
}
