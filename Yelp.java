package testing;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataprovider.ExcelUtils;
import pom.ExpandPage;
import pom.SearchPage;
import pom.SearchResultPage;
import dataprovider.ExcelUtils;
import pom.ExpandPage;
import pom.SearchPage;
import pom.SearchResultPage;

public class Yelp {
	
	WebDriver driver;
    String BASEURL = "https://www.yelp.com/sf";
    
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		driver = (WebDriver) new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.get(BASEURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethodInc() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	@DataProvider(name = "filter")
	  public static Object[][] credentials() throws Exception {
	      Object[][] testObjArray= ExcelUtils.getTableArray("D:\\newproject\\testing\\filter.xlsx","Sheet1");
	      return (testObjArray);
	  }

	 
	 @Test(enabled = true, priority = 1, alwaysRun = true,dataProvider = "filter")
     public void testOne(String filterOne, String filterTwo) throws Exception {
		 
		 SearchPage searchPage = new SearchPage(driver);
		 Reporter.log("Select Restaurants.......................");
		 SearchResultPage searchResultPage = searchPage.typeSearch("Restaurants");
		 Reporter.log("Append Pizza to Restaurants to make the search text as Restaurants Pizza.........................");
		 searchResultPage.typeSearch("Pizza Restaurants");
		 List<WebElement> numberOfResults = searchResultPage.numberOfSearchResult();
		 if(numberOfResults.size() == 0) {
      	   throw new Exception("No Result found after when searching for Pizza Restaurants");
         }
		 Reporter.log("Report total no. of Search results with no. of results in the current page "+numberOfResults.size());
		 Reporter.log("Selecting filter  " +filterOne);
		 searchResultPage.filter(filterOne);
		 Reporter.log("Selecting filter  " +filterTwo);
		 searchResultPage.filter(filterTwo);
		 numberOfResults = searchResultPage.numberOfSearchResult();
		 Reporter.log("Report total no. of Search results with no. of results in the current page "+numberOfResults.size());
		 if(numberOfResults.size() == 0) {
      	   throw new Exception("Search Result was not found after applying filter" +filterOne+":::"+filterTwo);
         }
		 Reporter.log("Report the star rating of each of the results in the first result page........................"); 
		 List<WebElement> starRating = searchResultPage.starRating();
		 List<WebElement> titleList = searchResultPage.titleList();
		 for (int i = 0; i < starRating.size(); i++) {
			 Reporter.log(titleList.get(i).getText());
			 Reporter.log(starRating.get(i).getAttribute("alt")+ "\n");
			}
		 Reporter.log("Click and expand the first result from the search results......................");
		 ExpandPage expandPage = searchResultPage.ClickIndexLinkOnSearchResult(0);
		 Reporter.log("Log all critical information of the selected restaurant details, for the reporting purpose..................");
		 Reporter.log("Address::"+expandPage.address());
		 Reporter.log("Phone::"+expandPage.phone());
		 Reporter.log("First 3 customer reviews.................................");
		 Map<Integer, String> customerReview = expandPage.customerReview();
		 for(String customerReviewString : customerReview.values()) {
			 Reporter.log(customerReviewString);
		    }
	 }
	 
}
