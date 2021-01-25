package selenideTests;

import org.junit.jupiter.api.*;
import selenide.pageObjects.HomePage;
import selenide.pageObjects.ReportportalRepoPage;
import selenide.pageObjects.SearchResultsPage;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GithubTests {
    private static HomePage homePage;
    private static SearchResultsPage searchResultsPage;
    private static ReportportalRepoPage reportportalRepoPage;
    private final int REPORTPORTAL_REPO_FILES_COUNT = 10;

    @BeforeAll
    public static void initPO(){
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        reportportalRepoPage = new ReportportalRepoPage();
    }

    @Test
    @Order(1)
    public void openingGithubHomePage(){
       homePage.openHomePage();
       assertThat(title()).contains("GitHub");
    }

    @Test
    @Order(2)
    public void searchTest(){
        homePage.searchField("reportportal");
        assertThat(searchResultsPage.searchResults().toString()).contains("reportportal");
    }

    @Test
    @Order(3)
    public void reportportalRepoOpeningTest(){
        searchResultsPage.reportportalLink().click();
        assertThat(title()).contains("reportportal");
    }

    @Test
    @Order(4)
    public void reportportalRepoFilesCountTest(){
        assertThat(reportportalRepoPage.getRepoFiles().size()).isEqualTo(REPORTPORTAL_REPO_FILES_COUNT);
    }
}
