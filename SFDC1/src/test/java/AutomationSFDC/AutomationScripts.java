package AutomationSFDC;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class AutomationScripts extends Reusable {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		Reusable re=new Reusable();
		
	
		LoginErrorMessage_1();
		LoginToSalesForce_2();
		Tc3_Test_the_rememberUsername_check();
		TC4_Test_ForgotPassword();
		ForgotPassword_4B();
		Tc5_Selectusemenu_usernamedropdown();
		Tc6_Editprofile_Data();
	Tc7_usernamedropdwn();
		Tc8_developerconsoledata();
    	Tc9_SelectLogoutUser_menu();
		Tc10_Create_acc();
        tc11_Create_new_view();
	}
	public static  void initialize_driver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\seema\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	public static void LoginToSFDC() throws InterruptedException, IOException
	{
		String [][] data=get_readXlData("C:\\Users\\seema\\git\\salesforce1\\SFDC1\\files\\login.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		Thread.sleep(4000);
		
	}
	public static void LoginErrorMessage_1() throws IOException, InterruptedException
	{
		
		createTestScriptReport("LoginErrorMessage_1");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc.xls","Sheet1");
        String URL=data[1][1];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" ); 
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		logger.log(LogStatus.PASS, "User Name is displayed in User name field" );
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		logger.log(LogStatus.PASS, "Password field is empty"); 
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		logger.log(LogStatus.PASS, "error message 'Please enter your password is displayed");
		Thread.sleep(4000);
		driver.close();
		Reportclose();
		
	}

	public static void LoginToSalesForce_2() throws InterruptedException, IOException
	{
		createTestScriptReport("LoginToSalesForce_2");
		initialize_driver();
		LoginToSFDC();
		driver.close();
		Reportclose();
	}
	public static void Tc3_Test_the_rememberUsername_check() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc3_Test_the_rememberUsername_check");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\login.xls","Sheet1");
        String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		
		Thread.sleep(4000);
		//driver.findElement(By.linkText("Login")).click();
		WebElement rememberme=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		selectcheckbox(rememberme,"check box");
		logger.log(LogStatus.PASS, "Login sales force page is displayed with <username> populated and remember user name checked");
		deselectcheckbox(rememberme,"check box");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		//driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(1000);
		WebElement usernamefield=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		usernamefield.click();
		WebElement logout=driver.findElement(By.xpath("//a[@title='Logout']"));
		logout.click();
//		WebElement validateUname=driver.findElement(By.xpath("//div[@id='username_container']"));
//		//validateUname.click();
//		logger.log(LogStatus.PASS, validateUname.getText());
		driver.close();
		Reportclose();
		
	}
	public static void TC4_Test_ForgotPassword() throws InterruptedException, IOException
	{
		createTestScriptReport("TC4_Test_ForgotPassword");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\login.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed");
        driver.findElement(By.xpath("//input[@id='un']")).click();
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		logger.log(LogStatus.PASS, "Password reset message page is displayed. An email associated with the <username> account is sent");
		driver.close();
Reportclose();
	}
	public static void ForgotPassword_4B() throws InterruptedException, IOException
	{
		createTestScriptReport("ForgotPassword_4B");
		initialize_driver();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc4B.xls","Sheet1");
		String URL=data[1][2];
		getURL( driver,URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Login")).click();
		//logger.log(LogStatus.PASS, "Salesforce application page is opened" );
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String username1=data[1][0];
		enterText(username, username1,"usernName");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String password1=data[1][1];
		enterText(password, password1,"password");
		WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		clickObj(login,"login");
		Thread.sleep(4000);
		WebElement error=driver.findElement(By.id("error"));
		String actuval="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		validateErrorMsg(actuval, error.getText());
		logger.log(LogStatus.PASS, error.getText());
		driver.close();
		Reportclose();
	}
	public static void Tc5_Selectusemenu_usernamedropdown() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc5_Selectusemenu_usernamedropdown");
		initialize_driver();
		LoginToSFDC();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS,"SalesForce login page is launched and application home page is logged in with correct username"  );
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		dropdown(usermenu,"usermenu");
		logger.log(LogStatus.PASS,"User menu drop down is displayed");
		logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
        Thread.sleep(4000);
		WebElement profiletab=driver.findElement(By.xpath("//a[@title='My Profile']"));
		System.out.println(usermenu.getText());
	    dropdown(profiletab,"profiletab");
	    driver.close();
		Reportclose();
	    
		}
	public static void Tc6_Editprofile_Data() throws InterruptedException, IOException
	{
		
       createTestScriptReport("Tc6_Editprofile_Data");
       String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
       initialize_driver();
	   LoginToSFDC();
       WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
       dropdown(usermenu,"usermenu");
	   logger.log(LogStatus.PASS,"User menu drop down is displayed");
	   logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
	   WebElement profiletab=driver.findElement(By.xpath("//a[@title='Profile Tab']"));
	   dropdown(profiletab,"profiletab");
	   Thread.sleep(4000);
		WebElement editprofile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		editprofile.click();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		switchFrame(driver,iframe);
		WebElement about=driver.findElement(By.id("aboutTab"));
		about.click();
		WebElement lastname=driver.findElement(By.name("lastName"));
		lastname.clear();
		String lastname2=data[1][0];
		enterText(lastname,lastname2,"lastname");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		switchFrameid( driver,"contactInfoContentId");
		WebElement saveall=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		clickObj(saveall,"saveall");
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		Thread.sleep(4000);
        logger.log(LogStatus.PASS,"postlink is displayed");
        WebElement profiletab1=driver.findElement(By.xpath("//a[contains(@title,'Profile Tab - Selected')]"));
        clickObj(profiletab1,"profiletab1");
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		WebElement iframe1=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		switchFrame(driver,iframe1);
		WebElement textbox=  driver.findElement(By.xpath("/html[1]/body[1]"));
		clickObj(textbox,"textbox");
		String textbox2=data[1][1];
		enterText(textbox,textbox2,"textbox");
		switchdefaultFrame(driver);
		System.out.println("i am out of teh frame");
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		logger.log(LogStatus.PASS,"postlink page is displayed successfullty");
		logger.log(LogStatus.PASS,"uploading the file is started");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		driver.findElement(By.xpath("//input[@id='chatterFile']")).click();
		System.out.println("file is choosen");
		logger.log(LogStatus.PASS,"file is choosen");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='chatterFile']")));
		String browse2=data[1][2];
		enterText(browse,browse2,"link"); 
		Thread.sleep(4000);
		 WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		 share.click();
		 Thread.sleep(4000);
		 logger.log(LogStatus.PASS,"uploading the file is done successfully");
		 driver.close();
			Reportclose();
		  
		}
	public static void Tc7_usernamedropdwn() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc7_usernamedropdwn");
	       String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
	       initialize_driver();
		   LoginToSFDC();
	      WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
	       dropdown(usermenu,"usermenu");
		   logger.log(LogStatus.PASS,"User menu drop down is displayed");
		   logger.log(LogStatus.PASS,"Drop down with "+"My profile"+ "My Settings"+ "Developer Console"+"Logout"+ "is displayed");
	      driver.findElement(By.linkText("My Settings")).click();
	      driver.findElement(By.id("PersonalInfo_font")).click();
	      driver.findElement(By.id("LoginHistory_font")).click();
    WebElement link=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
     link.click();
	WebElement displaylayout=driver.findElement(By.id("DisplayAndLayout_font"));
	displaylayout.click();
	WebElement custamizetabs=driver.findElement(By.id("CustomizeTabs_font"));
	custamizetabs.click();
	WebElement selectsalesforechatter=driver.findElement(By.id("p4"));
	SelectByindex( selectsalesforechatter,3);
	WebElement selectbutton=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
	SelectbyText(selectbutton,"Reports");
	WebElement add1=driver.findElement(By.xpath("//img[@title='Add']"));
	add1.click();
	System.out.println("email");
		WebElement email=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
		email.click();
		WebElement emailsetting=driver.findElement(By.id("EmailSettings_font"));
		emailsetting.click();
		WebElement ename=driver.findElement(By.name("sender_name"));
		ename.clear();
		ename.sendKeys("kalyani");
		WebElement eadd=driver.findElement(By.name("sender_email"));
		eadd.clear();
		eadd.sendKeys("seemakurthikalyani@gmail.com");
		//@SuppressWarnings("unchecked")
		List<WebElement> radiobutton=driver.findElements(By.name("auto_bcc"));
		boolean bval;
		bval=radiobutton.get(0).isSelected();
		if(bval==false)
		{
			radiobutton.get(0).click();
		}
		WebElement save3=driver.findElement(By.xpath("//input[@title='Save']"));
		save3.click();
	    System.out.println("calenderremainders");
		WebElement calendersandremainders=driver.findElement(By.id("CalendarAndReminders_font"));
	
		calendersandremainders.click();
		WebElement activityremainder=driver.findElement(By.id("Reminders_font"));
		
		activityremainder.click();
		WebElement opentestRe=driver.findElement(By.id("testbtn"));
		opentestRe.click();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[0]).close();
		 driver.close();
			Reportclose();
	
	}
	
	public static void Tc8_developerconsoledata() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc8_developerconsoledata");
		initialize_driver();
		logger.log(LogStatus.INFO, "Firefox browser is launced....");
		LoginToSFDC();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS,"SalesForce login page is launched and application home page is logged in with correct username"  );
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		dropdown(usermenu,"usermenu");
		logger.log(LogStatus.PASS,"User menu drop down is displayed");
		WebElement developerconsole=driver.findElement(By.linkText("Developer Console"));
		developerconsole.click();
//		Set<String> getAllWindows=driver.getWindowHandles();
//		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		windowhandler(driver);
		//driver.switchTo().window(window[1]).close();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "window is opened");
        driver.close();
		Reportclose();
	}
	public static void Tc9_SelectLogoutUser_menu() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc9_SelectLogoutUser_menu");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObj(usermenu,"usermenu");
		logger.log(LogStatus.INFO, "usermenu opened");
		driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.PASS, "logged out successfully");
		driver.close();
		Reportclose();
	}
	public static void Tc10_Create_acc() throws InterruptedException, IOException
	{
		createTestScriptReport("Tc10_Create_acc");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		WebElement new1=driver.findElement(By.name("new"));
		logger.log(LogStatus.INFO, "new button is opened");
		new1.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
		String accn=data[1][0];
        WebElement AccName=driver.findElement(By.id("acc2"));
		enterText(AccName,accn,"accn");
		//AccName.sendKeys("123456");
		WebElement save=driver.findElement(By.name("save"));
		save.click();
		System.out.println("executed");
		logger.log(LogStatus.PASS, "Account is created");
		driver.close();
		Reportclose();
		}
	public static void tc11_Create_new_view() throws InterruptedException, IOException
	{
		createTestScriptReport("tc11_Create_new_view");
		initialize_driver();
		LoginToSFDC();
		Thread.sleep(4000);
		WebElement accuontButton=driver.findElement(By.linkText("Accounts"));
		accuontButton.click();
		logger.log(LogStatus.INFO, "Accounts button is clicked");
		WebElement newview=driver.findElement(By.id("createNewButton"));
		newview.click();
		WebElement edit=driver.findElement(By.linkText("Edit"));
		edit.click();
		String [][] data=get_readXlData("C:\\Users\\seema\\OneDrive\\Desktop\\framework\\tc6.xls","Sheet1");
		String accn=data[1][0];
		WebElement btn=driver.findElement(By.id("fname"));
		enterText(btn,accn,"fname");
		//btn.sendKeys("kalyani");
		String accn1=data[1][1];
		WebElement btn1=driver.findElement(By.id("devname"));
		enterText(btn1,accn1,"devname1");
		//btn.sendKeys("kalyani");
		String accn2=data[1][2];
		WebElement btn2=driver.findElement(By.id("devname"));
		enterText(btn2,accn2,"devname2");
		//btn2.sendKeys("kalyani");
		WebElement save1=driver.findElement(By.name("save"));
		save1.click();
		logger.log(LogStatus.PASS,"newly added view is displayed");
		driver.close();
		Reportclose();
		}
}
