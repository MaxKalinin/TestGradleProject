package selenide.pageObjects;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class ReportportalRepoPage {
    public ElementsCollection getRepoFiles(){
        return $$("svg[aria-label=\"File\"]");
    }
}
