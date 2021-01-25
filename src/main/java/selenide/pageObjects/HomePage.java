package selenide.pageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class HomePage {
    public void openHomePage(){
        open("https://github.com/");
    }

    public void searchField(final String query){
        $(By.name("q")).setValue(query).pressEnter();
    }
}
