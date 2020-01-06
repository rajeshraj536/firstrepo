package testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import helper.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringUtils;

public class stringValue {
	
	private ErrorCollector collector=new ErrorCollector();
	private helper obj=new helper();
	private WebDriver driver;
    private String BASEURL="http://www.easports.com/tiger-woods/media?expanded=eao-all-recent";
    private static Logger logger = Logger.getLogger(NewTest.class);
	
	//http://stackoverflow.com/questions/2275004/in-java-how-to-check-if-a-string-contains-a-substring-ignoring-the-case
	
	//@Test
	public void kk(){
		List<WebElement> pp = driver.findElement(By.className("esc-select")).findElements(By.tagName("li"));
		for(int i = 0; i < pp.size(); i++)
		{
			//document.getElementsByClassName('secondary')
			 //Object kk = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML.value", (pp.get(i))).toString();
			 String script = "return arguments[0].innerHTML";
			 String Temp = (String) ((JavascriptExecutor) driver).executeScript(script,pp.get(i)); 
			 String pattern = "(<a.*?>)(.+?)(</a>)";
			 String updated = Temp.replaceAll(pattern, "$2"); 
			 System.out.println(updated);
			 //String xx = (String)kk;
			 
			 //System.out.println(xx);
			
			//System.out.println(pp.get(i).getText());
		}
		
		
	}
	
	
	   //@Test
		public void kk1() throws InterruptedException{
			driver.navigate().to("https://twitter.com/EASPORTSFIFA");
			
			 for (int second = 0;; second++) {
		            if(second >=60){
		                break;
		            }
		            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", "");
		                Thread.sleep(3000);
		             
		             List<WebElement> streamList =  driver.findElement(By.cssSelector("div.stream")).findElements(By.cssSelector("div.tweet"));
		   			 System.out.println("Stream List Size "+streamList.size()+"\n");
		            }
			 	
		}
	   
	  // @Test
		public void kk2() throws InterruptedException{
		   driver.navigate().to("https://twitter.com/EASPORTSFIFA");
                   driver.navigate().to("https://twitter.com/EASPORTSFIFA");
		   driver.findElement(By.cssSelector("a.media-thumbnail")).click();
		   Thread.sleep(10000);
		   System.out.println("Clicking on each Image");
		   
		   for(int  i = 0; i < 20; i++){
			   driver.findElement(By.cssSelector("span.nav-next-handle")).click();
			   Thread.sleep(3000);
		   }
		   
	   }
	   
	   
	   //@Test
	   private void kk3() throws InterruptedException{
		   int firstIndex = 0;
		   int SecondIndex = 0;
		    
		    driver.navigate().to("http://www.easports.com/");
		    System.out.println("Verify the marquee automatically cycles through (transition) without have to click anything.");
		    //TODO Find the elements of Marquee behaviour................
		    List<WebElement> marqueeItems = driver.findElement(By.className("marquee-pagination-container")).findElements(By.tagName("li"));
			System.out.println("we have number of marquee  "+marqueeItems.size());
			
			for( int repeat = 0; repeat < 10; repeat++)
			{
				for(int loop = 0; loop < 2; loop++)
				{
				       for( int i = 0; i < marqueeItems.size(); i++){
					        String tempfloat = marqueeItems.get(i).getAttribute("class");
					               if(tempfloat.contains("selected") && loop == 0){
						              firstIndex = i;
						              System.out.println(marqueeItems.get(i).getAttribute("class"));
						              System.out.println("Entered into first loop");
						              Thread.sleep(6000);
						              break;
					                 }
					                  else if(tempfloat.contains("selected") && loop == 1){
					                	  Thread.sleep(1000);
					                	  SecondIndex = i;
					                	  System.out.println(marqueeItems.get(i).getAttribute("class"));
					                	  System.out.println("Entered into second loop");
					                	  break;
					                 }
					
				        }
				}
				       
				       
				       if(firstIndex == SecondIndex){
				    	System.out.println("Marquee did not scroll"); 
				    	throw new AssertionError("Marquee did not scroll");
				       }	
			}
					
	   }
	   
	   @Test
	   private void kk22() throws InterruptedException{
		   int firstIndex = 0;
		   int SecondIndex = 0;
		   int local = 0;
		   WebElement firstIndexElement = null;
		   WebElement SecondIndexElement = null;
		    driver.navigate().to("http://www.easports.com/tiger-woods");
		    System.out.println("Verify the marquee automatically cycles through (transition) without have to click anything.");
		    //TODO Find the elements of Marquee behaviour................
		    
		    List<WebElement> marqueeItems = driver.findElement(By.className("jcarousel-control")).findElements(By.tagName("a"));
			System.out.println("we have number of marquee  "+marqueeItems.size());
			
			for( int repeat = 0; repeat < 10; repeat++)
			{
				for(int loop = 0; loop < 2; loop++)
				{
					local = 0;
				       for( int i = 0; i < marqueeItems.size(); i++){
					        String tempfloat = marqueeItems.get(i).getAttribute("class");
					               if(tempfloat.contains("selected") && loop == 0){
						              firstIndexElement = marqueeItems.get(i);
						              System.out.println(marqueeItems.get(i).getAttribute("class"));
						              System.out.println("Entered into first loop");
						              Thread.sleep(6000);
						              break;
					                 }
					                  else if(tempfloat.contains("selected") && loop == 1){
					                	  Thread.sleep(1000);
					                	  SecondIndexElement = marqueeItems.get(i);
					                	  System.out.println(marqueeItems.get(i).getAttribute("class"));
					                	  System.out.println("Entered into second loop");
					                	  if(firstIndexElement.equals(SecondIndexElement) && local == 0){
					                		System.out.println("continue");  
					  				    	Thread.sleep(5000);
					  				    	local = loop;
					  				    	i = 0;
					  				    	continue;
					  				       }
					                	  break;
					                 }
					
				        }
				}
				       
				       
				       if(firstIndexElement.equals(SecondIndexElement)){
				    	System.out.println("Marquee did not scroll"); 
				    	throw new AssertionError("Marquee did not scroll");
				       }	
			}
		    
					
	   }
	   
	
	
	
	 @BeforeMethod
	  public void beforeMethod() {
		  driver = new InternetExplorerDriver();
		  obj.windowMaximize(driver);
		  //driver.navigate().to(BASEURL);
		  PropertyConfigurator.configure("log4j.properties");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.manage().deleteAllCookies();
		  driver.quit();
	  }
	  

}
