package Assignment_Stepdefinition;

import static org.testng.Assert.assertEquals;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Stepdefinition {
	
WebDriver driver;
String Fname,Lname,Ename,Uname;
@Given("Signup into E-learn website")
public void signup_into_e_learn_website() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("http://elearningm1.upskills.in/");
    driver.findElement(By.xpath("//*[@id=\"login-block\"]/div/ul/li[1]/a")).click();
    
}
@When("Enter Fname,Lname,Email")
public void enter_fname_lname_email() {
    //driver.findElement(By.id("registration_firstname"));
    System.out.println("Enter Firstname");
    Scanner s = new Scanner(System.in);
    String Fname = s.nextLine();
    driver.findElement(By.id("registration_firstname")).sendKeys(Fname);
    System.out.println("Enter Lastname");
    Scanner l = new Scanner(System.in);
    String Lname = l.nextLine();
    driver.findElement(By.id("registration_lastname")).sendKeys(Lname);
    System.out.println("Enter Email");
    Scanner E = new Scanner(System.in);
    String Ename = E.nextLine();
    driver.findElement(By.id("registration_email")).sendKeys(Ename);
    System.out.println("Enter Username");
    Scanner U = new Scanner(System.in);
    String Uname = E.nextLine();
    driver.findElement(By.name("username")).sendKeys(Uname);
    driver.findElement(By.name("pass1")).sendKeys("M1randaa@");
    driver.findElement(By.name("pass2")).sendKeys("M1randaa@");
    driver.findElement(By.id("registration_submit")).click();
    String name = (driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/p[1]"))).getText();
	 String expcted= new String("Dear"+" "+Fname+" "+Lname+",");
	 if(name.contains(expcted))
	 {
	 System.out.println("Regitration is successful");
}
	 else
	 {
		 System.out.println(name);
	 }
	 driver.findElement(By.className("dropdown-toggle")).click();
	 String uname= driver.findElement(By.className("name")).getText();
	 if(uname.contains(Fname))
	 {
		 System.out.println("Name is validated");
	 }
	 else
	 {
		 System.out.println(uname);
	 }
	 String email= driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[1]/div/p")).getText();
	 if(email.contains(Ename))
	 {
		 System.out.println("Email validated");
		 
	 }
	 else
	 {
		 System.out.println(email);
	 }
	 
    
}


@Then("Click on Submit")
public void click_on_submit() throws InterruptedException {
	 
	 
	driver.findElement(By.linkText("Homepage")).click();
	driver.findElement(By.linkText("Compose")).click();
  //  Select drop= new Select(driver.findElement(By.id("select2-compose_message_users-results")));
    
   // drop.selectByVisibleText("Gayathri s (gaythri)");
	WebElement drop= driver.findElement(By.className("select2-search__field"));
	drop.sendKeys("gsk095@gmail.com");
	Thread.sleep(5000);
	drop.sendKeys(Keys.ENTER);
    driver.findElement(By.id("compose_message_title")).sendKeys("compose");
    Thread.sleep(5000);
    //driver.findElement(By.className("cke_editable cke_editable_themed cke_contents_ltr cke_show_borders")).sendKeys("sending email");
    driver.findElement(By.id("compose_message_compose")).click();
    String Messagedelivered=driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[1]")).getText();
    System.out.print(Messagedelivered);
    String emessage= new String("The message has been sent to Gayathri s (gayathri)");
    if(Messagedelivered.contains(emessage))
    		{
    	System.out.println("Message sent");
    		}
    else
    {
    	System.out.println("Message not sent");
    }
}}
