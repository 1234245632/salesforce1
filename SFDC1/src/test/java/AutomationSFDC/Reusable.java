package AutomationSFDC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reusable  {
	static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report;
	{
	report=new ExtentReports("C:\\Users\\seema\\OneDrive\\Desktop\\Report2.html",true);
	String path="C:\\Users\\seema\\OneDrive\\Desktop\\Report2.html";
	report=new ExtentReports(path);
	logger=report.startTest("Starts salesforce application");
	}
	public static ExtentTest createTestScriptReport(String testscriptName)
	{
		logger=report.startTest(testscriptName);
		return logger;
		
	}
	/* name of the method:   entertext
	 * BriefDescription  :   enetering textvalue for textboxes 
	 * Arguments         :  obj-->object
	 *                      textval--->to be entered 
	 *                      objName--->object name
	          
	 */
	public static void enterText(WebElement obj,String textval,String objName) throws InterruptedException

	{
		if(obj.isDisplayed())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: "+textval+"value is entered"+objName+"field");
			logger.log(LogStatus.PASS,textval+"value is entered"+objName+"field");
			
		}
		else
		{
			System.out.println("fail:" +objName+ "field does not exist please check application");
			logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
		}
	}
	
	/* name of the method:   clickobject--->Button
	 * BriefDescription  :   clicking a button
	 * Arguments         :  obj-->object,objName--->object name
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + "button is clicked");
			logger.log(LogStatus.PASS,objName + "button is clicked");
		}
		else
		{
			System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
			logger.log(LogStatus.PASS,objName+"button is not displayed ,please check the application");
		}
	}
	
	/* name of the method:  dropdown
	 * BriefDescription  :   dropdown 
	 * Arguments         :  obj-->object,objName--->object name                     
	           
	 */
	public static void dropdown(WebElement obj,String objName)	
	{
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
			}else{
			obj.click();
			System.out.println("Pass: "+objName+" is now selected");
			logger.log(LogStatus.PASS, objName+" is now selected");
		    }
			}
			else {
			System.out.println("Fail:"+objName+" is not present Please chk application");
			logger.log(LogStatus.FAIL, objName+" is not present Please chk application");
			
		}	
	}
	/* name of the method:   validateErrorMsg
	 * BriefDescription  :   validateErrorMsg
	 * Arguments         :  actuvalmsg,errormsg
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	public static void validateErrorMsg(String actualval , String expectedval) {
		if(actualval.equals(expectedval))
	    {
	     System.out.println("Test Case Pass");
	   //  logger.log(LogStatus.PASS, "Test Case Pass");
	    }else
	    {
	     System.out.println("Test Case Fail");
	    // logger.log(LogStatus.FAIL, "Test Case Fail");
	    }			
	 }
	/* name of the method:   iFrame
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->webelement
	         
	 */
	public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	    }
	 }
	/* name of the method:   switchFrameid
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	          
	 */
	public static void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	    }
	 public static void getURL(WebDriver driver,String obj) {
		if(obj.equals(obj)) {
			driver.get(obj);
		System.out.println("Pass: "+obj+" is present");
		//logger.log(LogStatus.PASS,obj+"value is entered"+obj+"field");
		}
     else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			//logger.log(LogStatus.FAIL,obj+"value is entered"+obj+"field");
		}
	} 
	 /* name of the method:   switchdefaultFrame
		 * BriefDescription  :   iframe for switching back to default frame 
		 * Arguments         :  driver--->driver 
		         
		 */ 
		public static void switchdefaultFrame( WebDriver driver)
		{
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the "+driver+ " back to frame");
	}
		 /* name of the method:   switchdefaultFrame
		 * BriefDescription  :   iframe for switching back to default frame 
		 * Arguments         :  driver--->driver 
		          
		 */ 
		public static Window windowhandler( WebDriver driver)
		{
			Set<String> getAllWindows=driver.getWindowHandles();
			String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
			System.out.println(getAllWindows.size());
			return null;
			
//			driver.switchTo().window(window[getAllWindows.size()]).close();
			}
		/* name of the method:   selectDropdown
		 * BriefDescription  :   selected by clicking the dropdown 
		 * Arguments         :  obj,objName 
		        
		 */ 
		public static void SelectbyText(WebElement we, String VisibleText){
			   if(we.isDisplayed())
			   {
				   Select selObj=new Select(we);
		           selObj.selectByVisibleText(VisibleText);
			           System.out.println("Pass: "+VisibleText+ " is Sected by VisibleText" );
			   } 
			   else
			   {
			    System.out.println("Fail: "+VisibleText+ " is not available");
			   }
			   }
		/* name of the method:   SelectByindex
		 * BriefDescription  :   selected by clicking the dropdown 
		 * Arguments         :  obj,index 
		          
		 */ 
		public static void SelectByindex(WebElement obj, int index) {
			  if(obj.isDisplayed()) {
			   Select selObj=new Select(obj);
			    
			   selObj.selectByIndex(index);
			  System.out.println("pass:"+index + " is selected from drop down ");
			  }else {
			   System.out.println("Fail:"+index+"is not selected");
			  }
			 }
		/* name of the method: radioButton
		 * BriefDescription  :   radioButton 
		 * Arguments         :  obj-->object,objName--->object name                     
		         
		 */
		
		public static void radioButton1(WebElement obj, String objName) {
			if(obj.isDisplayed()) {
				if(obj.isSelected()) {
					System.out.println("Pass: "+objName+" is already selected");
				}else{
				obj.click();
				System.out.println("Pass: "+objName+" is now selected");
			    }
				}
				else {
				System.out.println("Fail:"+objName+" is not present Please chk application");			
			}	
		}
		/* name of the method:   deselectcheckbox
		 * BriefDescription  :   deselectcheckbox 
		 * Arguments         :  obj-->object,objName--->object name                     
		          
		 */
		public static void deselectcheckbox(WebElement obj,String objName)
		{
			if(obj.isEnabled())
			{
				obj.click();
				System.out.println("pass:" +objName+"is disabled");
				
				
					//System.out.println("pass:"+objName+"is alredy selected");
			}	
				
				else
				{
					
					System.out.println("Fail:" +objName+ "is not deselected");
				}
			}
		/* name of the method:   selectcheckbox for checkbox
		 * BriefDescription  :   checkbox on,checkbox of 
		 * Arguments         :  obj-->object,objName--->object name                     
		          
		 */
		public static void selectcheckbox(WebElement obj,String objName)
		{
			if(obj.isDisplayed())
			{
				System.out.println(objName+"is present");
				if(obj.isSelected())
				{
					System.out.println("pass:"+objName+"is alredy selected");
				}
				else
				{
					obj.click();
					System.out.println("pass:" +objName+ "is now clicked");
				}
			}
		}
		/* name of the method:   switchtoAlert
		 * BriefDescription  :   Switch to alert
		 * Arguments         :  driver,obj
		          
		 */ 
		public static void switchtoAlert(WebDriver driver,Alert alert) {
			if(alert.equals(alert))
			{
				alert=driver.switchTo().alert();
				alert.accept();
			 System.out.println("Pass: "+alert+" is present");
	    }
			else
			{
				System.out.println("Fail: "+alert+" is not present");	
			}
		}
		/* name of the method: Reportclose
		 * BriefDescription  :   Reportclose 
		 * Arguments         :  obj-->object,objName--->object name                     
		 *  createdby        :  Automation team 
		 *  created date     :02/13/19 
		 *  LastModified Date:02/13/19          
		 */
		
		public static void Reportclose() {
			report.endTest(logger);
			report.flush();
		}
			
		
		
		 
	public static String[][] get_readXlData( String path,String sheetName) throws IOException{
		//FileInputStream fs=new FileInputStream(new File("C:\\Users\\seema\\eclipse-workspace\\Readwrite\\files\\helloworld2.xls"));
		FileInputStream fs=new FileInputStream(new File(path));	
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet(sheetName);
		
		int rowCount=sheet.getLastRowNum()+1;
		int colCount=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
					int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
					data[i][j]=String.valueOf(val);
				}
				else
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			}	
return data;
		
	}
	public static void writeXlData(int i,String result,String color) throws IOException{

		File file=new File("C:\\Users\\seema\\OneDrive\\Desktop\\fwsa.xls");

		FileInputStream fs=new FileInputStream(file);

		HSSFWorkbook wb=new HSSFWorkbook(fs);

		HSSFSheet sheet=wb.getSheet("Sheet1");
		HSSFCellStyle style = ((HSSFWorkbook)wb).createCellStyle();	

		if (color.equals("Green")){

			style.setFillForegroundColor(HSSFColor.GREEN.index);

		}

			else if (color.equals("Red")) {

				style.setFillForegroundColor(HSSFColor.RED.index);

			}

			else {

				style.setFillForegroundColor(HSSFColor.BLUE.index);

			}

		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 

		sheet.getRow(i).getCell(3).setCellValue(result);
		sheet.getRow(i).getCell(3).setCellStyle(style);

		FileOutputStream fo=new FileOutputStream(file);

		wb.write(fo);

		fo.flush();

		fo.close();

		System.out.println("completed");
	}
	
	
	}




