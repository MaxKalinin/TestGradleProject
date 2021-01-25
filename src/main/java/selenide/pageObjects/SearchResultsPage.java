package selenide.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public SelenideElement reportportalLink(){
        return $("a[href=\"/reportportal/reportportal\"]");
    }

    public ElementsCollection searchResults(){
        return $$("a[class='v-align-middle']");
    }
}
